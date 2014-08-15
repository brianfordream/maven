package ConsumerProducer;

import java.util.List;
import java.util.Random;

public class Consumer<T> implements Runnable{
	private List<T> items;
	Random random=new Random();
	public Consumer(List<T> items){
		this.items=items;
	}
	private int getLength(){
			return items.size();
	}
	public void consume(){
		int i=0;
		synchronized(items){
		while((i=this.getLength())<=0)
			try {
				items.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			T t=items.remove(0);
			System.out.println("Consuming:"+i);
			items.notifyAll();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
			Thread.sleep(random.nextInt(100));
			consume();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
