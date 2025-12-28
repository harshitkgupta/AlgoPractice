package thread;
public class EvenOddThreadDemo {

	 public static void main(String[] args) {
	  // shared class object
	  SharedPrinter1 sp = new SharedPrinter1();
	  // creating two threads
	  Thread t1 = new Thread(new EvenNumProducer1(sp, 100));
	  Thread t2 = new Thread(new OddNumProducer1(sp, 100));
	  // starting threads
	  t1.start();
	  t2.start();
	 }
}
	
	// Shared class used by both threads
	class SharedPrinter1 {
	 boolean evenFlag = false;
	 
	 //Method for printing even numbers
	 public void printEvenNum(int num) throws InterruptedException{
	  synchronized (this) {
		  System.out.println("Even thread has taken the lock");
	    // While condition as mandated to avoid spurious wakeup
	   while(!evenFlag){
	    try {
	     //asking current thread to give up lock
	    System.out.println("Even thread given up lock");
	     wait();
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   }
	   System.out.println(num);
	   evenFlag = false;
	   Thread.sleep(1000);
	   // Wake up thread waiting on this monitor(lock)
	   notify();
	   
	  }
	  
	 
	}
	 
	 //Method for printing odd numbers
	 public void printOddNum(int num){
	  synchronized (this) {
		  System.out.println("Odd thread has taken the lock");
	    // While condition as mandated to avoid spurious wakeup
	   while(evenFlag){
	    try {
	     //asking current thread to give up lock
	    	System.out.println("Odd thread given up lock");
	     wait();
	    } catch (InterruptedException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	    }
	   }
	   System.out.println(num);
	   evenFlag = true;
	   // Wake up thread waiting on this monitor(lock)
	   notify();
	   
	  }
	 }
	 }
	 class EvenNumProducer1 implements Runnable{
		    SharedPrinter1 sp;
		    int index;
		    EvenNumProducer1(SharedPrinter1 sp, int index){
		        this.sp = sp;
		        this.index = index;
		    }
		    @Override
		    public void run() {
		        for(int i = 2; i <= index; i = i+2){
		            try {
						sp.printEvenNum(i);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        
		    }
		    
		}

		//Thread Class generating Odd numbers
		class OddNumProducer1 implements Runnable{
		    SharedPrinter1 sp;
		    int index;
		    OddNumProducer1(SharedPrinter1 sp, int index){
		        this.sp = sp;
		        this.index = index;
		    }
		    @Override
		    public void run() {
		        for(int i = 1; i <= index; i = i+2){
		            sp.printOddNum(i);
		        }
		    }
		}