package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler<T> implements InvocationHandler {
	private T o;
	public Handler(T o){
		this.o=o;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
	try {	System.out.println("Before sing");
		return method.invoke(o, args); 
	}
	finally{
		System.out.println("After sing");
	}

	}

}
