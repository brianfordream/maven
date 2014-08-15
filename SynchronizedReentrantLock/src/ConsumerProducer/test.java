package ConsumerProducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 使用wait，notify的生产者消费者模型
 * 队列的大小为10，为空或者为满时则阻塞
 */
public class test {
	public static void main(String args[]){
		List<Integer> items=new LinkedList<Integer>();
		Consumer<Integer> c1=new Consumer<Integer>(items);
		Consumer<Integer> c2=new Consumer<Integer>(items);
		Consumer<Integer> c3=new Consumer<Integer>(items);
		Consumer<Integer> c4=new Consumer<Integer>(items);
		Consumer<Integer> c5=new Consumer<Integer>(items);
		Producer<Integer> p1=new Producer<Integer>(items);
		Producer<Integer> p2=new Producer<Integer>(items);
		Producer<Integer> p3=new Producer<Integer>(items);
		ExecutorService service=Executors.newCachedThreadPool();
		service.execute(c1);
		service.execute(c2);
//		service.execute(c3);
//		service.execute(c4);
//		service.execute(c5);
		service.execute(p1);
		service.execute(p2);
		service.execute(p3);
	}
}
