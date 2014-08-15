package ConsumerProducer2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionBoundBuffer<T>{
	private final int BUFFER_SIZE=10;
	private Lock lock=new ReentrantLock();
	private Condition isFull = lock.newCondition();
	private Condition isEmpty=lock.newCondition();
	private int head,tail,count;
	private final T[] items= (T[]) new Object[BUFFER_SIZE];
	public void put(T x) throws InterruptedException{
		lock.lock();
		try{
			while(count==BUFFER_SIZE)
				isFull.await();
			items[tail]=x;
			if(++tail==BUFFER_SIZE)
				tail=0;
			++count;
			System.out.println("put:"+count);
				isEmpty.signal();
		}finally{
			lock.unlock();
		}
	}
	public T get() throws InterruptedException{
		lock.lock();
		try{
			while(count==0)
				isEmpty.await();
			System.out.println("get"+count);
			T t=items[head];
			items[head]=null;
			if(++head==BUFFER_SIZE)
				head=0;
			--count;
			isFull.signal();
			return t;
		}finally{
			lock.unlock();
		}
	}
}
