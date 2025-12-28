import java.util.concurrent.Semaphore;

import thread.SharedCounter;

public class SemaphoreDemo {
 public static void main(String[] args) {
  SharedCounter counter = new SharedCounter();
  // Creating three threads
  Thread t1 = new Thread(counter, "Thread-A");
  Thread t2 = new Thread(counter, "Thread-B");
  Thread t3 = new Thread(counter, "Thread-C");
  t1.start();
  t2.start();
  t3.start();
 }
}

class SharedCounter  implements Runnable{
    private int c = 0;
    Semaphore sp = new Semaphore(1);

    // incrementing the value
    public void increment() {
        try {
         // used sleep for context switching
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        c++;
    }
    // decrementing the value
    public void decrement() {    
        c--;
    }

    public int getValue() {
        return c;
    }
    
    @Override
    public void run() {
    	try {
			sp.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        this.increment();
        System.out.println("Value for Thread After increment - " + Thread.currentThread().getName() + " " + this.getValue());
        this.decrement();
        System.out.println("Value for Thread at last " + Thread.currentThread().getName() + " " + this.getValue());
        sp.release();
    }
}