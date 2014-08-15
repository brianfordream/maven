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
		}//���ʹ��Lock���������С������unlock����ô���������������ʹ��tryLock�򲻻�����������,û�а취��ȡ���Ľ��̽��˳�
		return -1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			//ֻ�ж�interrupt���д��������жϣ����û�����������������������޷�����
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
