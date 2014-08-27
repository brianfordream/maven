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

import controller.GrabTheCode.WordDict;

@Controller
@RequestMapping(value="/query")
public class QueryWordFromWeb {
	private static MemcachedClient client;
	private static GrabTheCode grab;
	static{
			try {
				grab=new GrabTheCode();
				client=new MemcachedClient(AddrUtil.getAddresses("192.168.161.137:11211 "));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam(value="word")String keyWord){
		ModelAndView mv=new ModelAndView();
		WordDict result;
		System.out.println(client.get(keyWord));

			result=grab.grab(keyWord);
		mv.addObject("result",result);
		mv.setViewName("dictitem");
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
