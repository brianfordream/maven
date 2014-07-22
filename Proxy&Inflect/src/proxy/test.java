package proxy;

import java.lang.reflect.Proxy;

public class test {
	public static void main(String args[]){
		Sing b=new Bird();
		Handler<Sing> h=new Handler<Sing>(b);
		b=(Sing) Proxy.newProxyInstance(b.getClass().getClassLoader(), b.getClass().getInterfaces(), h);
		b.sing();
	}
}
