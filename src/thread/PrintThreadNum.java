package thread;
class MyPrinter implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep((int)(Math.random()*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Name : "+Thread.currentThread().getName()+" ------ id : "+Thread.currentThread().getName());
	}
	
}
public class PrintThreadNum {
	public static void main(String args[]) {
		MyPrinter p = new MyPrinter();
		for(int i=0;i<10;i++) {
			Thread t = new Thread(p);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
