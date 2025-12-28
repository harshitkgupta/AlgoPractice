package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintInSequence {

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		es.execute(new SharedPrinter2(0));
		es.execute(new SharedPrinter2(1));
		es.execute(new SharedPrinter2(2));
	}
}
	
	class SharedPrinter2 implements Runnable{
		SharedPrinter2(int threadNum){
			this.threadNum=threadNum;
		}
		static int THREADS_COUNT=3;
		int threadNum;
		volatile  int number =1;
		Object lock = SharedPrinter2.class;
		@Override
		public void run() {
			synchronized(lock) {
				System.out.println("Thread "+threadNum+" inside lock");
				while(number<10) {
				while(number % THREADS_COUNT != threadNum ) {
					try {
						System.out.println("Thread "+threadNum+" waiting");
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Thread "+threadNum+" Num after while "+number);
				}
				System.out.println("Thread "+threadNum+ " --- "+number);
				number++;
				lock.notifyAll();
				System.out.println("Thread "+threadNum+" outside lock");
				}
			}
			
		}
		
	}


