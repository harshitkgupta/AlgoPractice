package thread;
import java.util.concurrent.Semaphore;


public class OddEvenUsingSemaphore {
	public static void main(String args[]){
		SharedPrinter sp = new SharedPrinter();
		int count = 1000_000;
		Thread oddPrinter = new Thread(new OddNumProducer(sp, count));
		Thread evenPrinter = new Thread(new EvenNumProducer(sp, count));
		oddPrinter.start();
		evenPrinter.start();
		try {
			oddPrinter.join();
			evenPrinter.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
}
class SharedPrinter{
	private Semaphore oddSem = new Semaphore(1);
	private Semaphore evenSem = new Semaphore(0);
	
	void printOdd(int num){
		try {
			oddSem.acquire();
			System.out.println(num);
			evenSem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}
	
	void printEven(int num){
		try {
			evenSem.acquire();
			System.out.println(num);
			oddSem.release();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class OddNumProducer implements Runnable{
	SharedPrinter sp;
	int count;
	
	public OddNumProducer(SharedPrinter sp, int count) {
		this.sp=sp;
		this.count=count;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=count;i+=2){
			sp.printOdd(i);
		}
	}	
}

class EvenNumProducer implements Runnable{
	SharedPrinter sp;
	int count;
	
	public EvenNumProducer(SharedPrinter sp, int count) {
		this.sp=sp;
		this.count=count;
	}
	
	@Override
	public void run() {
		for(int i=2;i<=count;i+=2){
			sp.printEven(i);
		}
	}	
}
