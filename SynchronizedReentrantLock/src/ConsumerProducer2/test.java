package ConsumerProducer2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
 * 使用ReentrantLock 和 Condition 通过构造一个ConditionBoundBuffer的数据结构来实现生产者消费者模型所需要的缓冲队列，通过显式条件变量保证其线程安全
 * 这样通过封装简化了生产者和消费者中的定义
 */
public class test {
	public static void main(String args[]){
		ConditionBoundBuffer<Integer> items=new ConditionBoundBuffer<Integer>();
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
