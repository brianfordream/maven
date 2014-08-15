package ConsumerProducer;

import java.util.List;
import java.util.Random;

public class Producer<T> implements Runnable {
	Random random=new Random();
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
		product();
		}
	}
	private List<T> items;
	private int getLength(){

			return items.size();
		
	}
	public Producer(List<T> items){
		this.items=items;
	}
	public void product(){
		int i=0;
		synchronized(items){
		if((i=getLength())>10)
			try {
				items.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			T t = null;
			items.add(t);
			items.notifyAll();
			System.out.println("Producing:"+(++i));
		}
	}
}
