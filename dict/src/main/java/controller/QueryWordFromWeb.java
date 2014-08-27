package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.WordDict;
import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value="/query")
public class QueryWordFromWeb {
	private static MemcachedClient client;
	private static GrabTheCode grab=new GrabTheCode();
	
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView find(@RequestParam(value="word")String keyWord){
		ModelAndView mv=new ModelAndView();
		WordDict result;
			result=grab.grab(keyWord);
			if(result!=null){
				mv.addObject("result",result);
			}
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
