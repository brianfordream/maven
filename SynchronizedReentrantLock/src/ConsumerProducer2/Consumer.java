package ConsumerProducer2;

import java.util.Random;

public class Consumer<T> implements Runnable {
	private ConditionBoundBuffer<T> buffer;
	Random random=new Random();
	public Consumer(ConditionBoundBuffer<T> buffer){
		this.buffer=buffer;
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
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void consume() throws InterruptedException{
		buffer.get();
	}
}
