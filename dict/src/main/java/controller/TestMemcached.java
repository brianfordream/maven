package controller;

import java.io.IOException;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.MemcachedClient;

public class TestMemcached {
	public static void main(String[] args) throws IOException {
		MemcachedClient client=new MemcachedClient(AddrUtil.getAddresses("192.168.161.137:11211"));
		
		client.set("key1",0,"100");
		Object o=client.get("key1");
		client.incr("key1", 1);
		System.out.println(o);
	}
}
