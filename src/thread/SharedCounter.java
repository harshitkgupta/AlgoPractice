package thread;

public class SharedCounter implements Runnable {
	static int ct = 0;
	int c=0;
	public static void main(String args[]) throws InterruptedException {
		int n = 10;

		Thread th[] = new Thread[n];
		for (int i = 0; i < n; i++) {
			th[i] = new Thread(new SharedCounter(), "" + i);
		}
		for (int i = 0; i < n; i++) {
			th[i].start();
		}
		for (int i = 0; i < n; i++) {
			th[i].join();
		}
	}

	@Override
	public void run() {
		while(c<100)
		{	
		synchronized (SharedCounter.class) 
			{	
		ct++;System.out.println("Thread "+Thread.currentThread().getName() + " count : " + ct);}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c++;
		
		}
	}
}
