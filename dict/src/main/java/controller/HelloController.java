package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RequestMapping(value="/hello")
public class HelloController {
	private static MemcachedClient client;
	static{
		try {
			client=new MemcachedClient(AddrUtil.getAddresses("192.168.161.137:11211  "));
			Resource resource=new ClassPathResource("dict.txt");
			InputStreamReader reader=new InputStreamReader(resource.getInputStream(),"GB2312");
			BufferedReader buffer=new BufferedReader(reader);
			String line;
			while((line=buffer.readLine()) !=null){
				load(line);
			}
			buffer.close();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private  static void load(String line) {
		String[] splitStrings=line.split(" ");
		String key=splitStrings[0];
		String value=splitStrings[1];
		client.set(key, 0, value);
	}
	@RequestMapping(value="/sayHello" ,method=RequestMethod.GET)
	public ModelAndView sayHello(){
		ModelAndView mv=new ModelAndView();
		mv.addObject("name","yang");
		mv.setViewName("hello");
		return mv;
	}
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam(value="word")String keyWord){
		ModelAndView mv=new ModelAndView();
		String result=(String) client.get(keyWord);
		mv.addObject("result",result);
		mv.addObject("query",keyWord);
		mv.setViewName("result");
		return mv;
	}
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView find(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("query");
		return mv;
	}
	public void initDict(){
		
	}
}
