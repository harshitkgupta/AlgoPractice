package thread;

public class PrintCounting {
	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++) {
			Thread t = new Thread(new CountRunnable(i));
			t.start();
			//System.out.println("Thread "+i+" started");
		}
	}
}

class CountRunnable implements Runnable {
	int id;
	static volatile int count = 0;
	private static final int NUM_THREADS = 10;
	private static final int LIMIT = 20;

	public CountRunnable(int id) {
		this.id = id;
	}

	@Override
	public void run() {
	    outer:
		while (count <= LIMIT) {
				while (count % NUM_THREADS != id) {
					if(count>=LIMIT) break outer;
					continue;
				}
				System.out.print("Thread id " + id + " " + count +"\n");
				count++;	
		}
	}

}