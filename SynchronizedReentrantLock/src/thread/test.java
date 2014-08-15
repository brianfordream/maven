package thread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test implements Runnable{
	 int i=0;
	Lock lock=new ReentrantLock();
	public  int  get() {
		if(lock.tryLock()){
			try{
				i++;
				return i;
			}finally{
				lock.unlock();
			}
		}//如果使用Lock并且如果不小心忘记unlock，那么程序将阻塞，而如果使用tryLock则不会出现这种情况,没有办法获取锁的进程将退出
		return -1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//只有对interrupt进行处理，才能中断，如果没有下面的这个跳出条件，则无法结束
			if(Thread.currentThread().isInterrupted())
				break;
			System.out.println(Thread.currentThread().getName()+":"+get());
		}

	}
	public static void main(String args[]) throws InterruptedException{

		ExecutorService executor=Executors.newCachedThreadPool();
		Runnable r=new test();
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
		Thread.sleep(5);
		executor.shutdownNow();
	}
}
