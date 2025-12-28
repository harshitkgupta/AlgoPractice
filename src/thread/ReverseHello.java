package thread;

public class ReverseHello implements Runnable{
	static int i=0;
	public static void main(String args[]) throws InterruptedException{
		Thread t = new Thread(new ReverseHello(),""+(++i));
		t.start();
		t.join();
	}

	@Override
	public void run() {		
		if(i<50)
		{
			Thread t = new Thread(new ReverseHello(),""+(++i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Hello from Thread "+Thread.currentThread().getName());
	}
}