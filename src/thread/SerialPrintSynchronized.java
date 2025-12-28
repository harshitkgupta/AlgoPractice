package thread;

public class SerialPrintSynchronized {
	public static void main(String[] args) {
		SynchronizedSharedPrinter sp = new SynchronizedSharedPrinter();
		for(int i=0; i <100; i++){
			Thread t = new Thread(sp);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class SynchronizedSharedPrinter implements Runnable{
		int i=1;

		@Override
		public void run() {
			synchronized (this) {
				System.out.println(i);
				i++;
			}
			
		}		
	}
}
