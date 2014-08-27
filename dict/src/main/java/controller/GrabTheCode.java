package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;
import model.Item;
import model.WordDict;

public class GrabTheCode {
	private static MemcachedClient client;
	private static URL myURL;
	static{
		try {
			client=new MemcachedClient(AddrUtil.getAddresses("192.168.161.137:11211"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public WordDict grab(String word){
		if(word==null || word.equals(""))
			return null;
		WordDict dict;
		if((dict=(WordDict) client.get(word))!=null){
			System.out.println("Read from memcached");
			return dict;
		}
		System.out.println(dict);
		dict=new WordDict();
		try {
			myURL=new URL("http://www.iciba.com/"+word);
			InputStreamReader isr=new InputStreamReader(myURL.openStream(),"utf8");
			BufferedReader br=new  BufferedReader(isr);
			String buffer;
			String tmp;
			Item item=new Item();
			dict.setWordName(word);
			boolean flag=false;
			boolean qualifierFlag=false;
			List<String> tmpExplain=new LinkedList<String>();
			List<Item> tmpItem=new LinkedList<Item>();
			while((buffer=br.readLine())!=null){
				buffer=buffer.trim();
				buffer=buffer.replaceAll("\t", "");
				if(buffer.startsWith("<div class=\"group_pos\">"))
						{
							flag=true;
							continue;
						}
				if(!flag)
					continue;
		
				if( buffer.startsWith("<strong class=\"fl\">")){
					int index=buffer.indexOf(">");
					int end=buffer.lastIndexOf("<");
					tmp=buffer.substring(index+1,end);
					 item=new Item();
					 tmpExplain=new LinkedList<String>();
					item.setQualifier(tmp);
					continue;
				}
				else	if(buffer.startsWith("<span")){
					qualifierFlag=true;
					continue;
				}
				else	if(qualifierFlag && buffer.startsWith("<label>")){
					int index=buffer.indexOf(">");
					int end=buffer.lastIndexOf("<");
					tmp = buffer.substring(index+1,end);
					tmpExplain.add(tmp);
					continue;
				}
				else  if(qualifierFlag && buffer.endsWith("</span>")){
					qualifierFlag=false;
					item.setExplain(tmpExplain);
		
					tmpItem.add(item);
					continue;
				}
				else	if(buffer.startsWith("</div>")){
					flag=false;
					dict.setWordExplain(tmpItem);
					System.out.println("Read from Internet");
					break;
				}
			}
			client.add(word, 0, dict);
			return dict;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dict;

	}	

	public static void main(String[] args) {
		GrabTheCode grab=new GrabTheCode();
		WordDict dict=grab.grab("father");
		for(Item item:dict.getWordExplain())
			System.out.println(item.getExplain());
	}
}