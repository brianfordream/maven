package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import model.WordDict;

public class GrabTheCode {
	private String content;
	public WordDict grab(String word){
		WordDict dict=new WordDict();
		try {
			URL myURL=new URL("http://www.iciba.com/"+word);
			InputStreamReader isr=new InputStreamReader(myURL.openStream(),"utf8");
			BufferedReader br=new  BufferedReader(isr);
			String buffer;
			String tmp;
			dict.setWordName(word);
			boolean flag=false;
			while((buffer=br.readLine())!=null){
				buffer=buffer.trim();
				buffer=buffer.replaceAll("\t", "");
				if(buffer.startsWith("<div class=\"group_pos\">"))
						{
							flag=true;
						}
				if(!flag)
					continue;
				if(buffer.startsWith("<strong class=\"fl\">")){
					int index=buffer.indexOf(">");
					int end=buffer.lastIndexOf("<");
					tmp=buffer.substring(index+1,end);
					dict.getWordExplain().add(tmp+" ");
				}
				if(buffer.startsWith("<label>")){
					int index=buffer.indexOf(">");
					int end=buffer.lastIndexOf("<");
					tmp = buffer.substring(index+1,end);
					dict.getWordExplain().add(tmp+" ");					
				}
				if(buffer.startsWith("</div>"))
					break;
			}
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
		System.out.println(dict.getWordName());
		System.out.println(dict.getWordExplain());
	}
}