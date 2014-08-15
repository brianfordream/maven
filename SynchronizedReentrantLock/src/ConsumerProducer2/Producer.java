package ConsumerProducer2;

import java.util.Random;

public class Producer<T> implements Runnable {
	private ConditionBoundBuffer<T> buffer;
	Random random=new Random();
	public Producer(ConditionBoundBuffer<T> buffer){
		this.buffer=buffer;
	}
	public void Product() throws InterruptedException{
		T t =null;
		buffer.put(t);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Product();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
