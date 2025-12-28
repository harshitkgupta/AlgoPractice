package thread;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class ProducerConsumerUsingSemaphore {
	public static void main(String args[]){
		SharedBox sp = new SharedBox();
		Thread producer = new Thread(new SemProducer(sp));
		Thread consumer = new Thread(new SemConsumer(sp));
		producer.start();
		consumer.start();
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
}
class SharedBox{
	private int item;
	
	private Semaphore prodSem = new Semaphore(1);
	private Semaphore conSem = new Semaphore(0);

	public void put(int i) {
		try {
			prodSem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		item = i;
		System.out.println("Producer produced "+item);
		conSem.release();		
	}
	public int get() {
		try {
			conSem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int comsumed = item;
		System.out.println("Consumer consumed "+comsumed);
		prodSem.release();
		return comsumed;
	}
}

class SemProducer implements Runnable{
	private Random rd = new Random();
	private SharedBox sb;	
	public SemProducer(SharedBox sb) {
		super();
		this.sb = sb;
	}
	@Override
	public void run() {
		for(int i=0; i < 100;i++)
		{			
			sb.put(rd.nextInt());
		}		
	}	
}
class SemConsumer implements Runnable{
	private SharedBox sb;	
	public SemConsumer(SharedBox sb) {
		super();
		this.sb = sb;
	}

	@Override
	public void run() {
		for(int i=0; i < 100;i++)
		{			
			sb.get();
		}		
	}	
}
