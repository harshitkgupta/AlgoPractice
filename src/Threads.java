
public class Threads {
	public static int c=0;
	
	public static void main(String args[]){
		Runnable r =()-> {while(c<100)System.out.println(Thread.currentThread().getName()+"  -  "+(c++));};
		Thread t1 = new Thread(r,"one");
		Thread t2 = new Thread(r,"two");
		t1.start();
		t2.start();
	}

}
