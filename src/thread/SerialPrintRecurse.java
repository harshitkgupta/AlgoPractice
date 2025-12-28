package thread;

public class SerialPrintRecurse {
	public static void main(String[] args) {
		Thread t = new Thread(new Printer(1));
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	static int count = 100;
	static class Printer implements Runnable{
		
		private int i;
		
		Printer(int i){
			this.i = i;
		}
		
		@Override
		public void run() {
			if(i>count)
				return;
			System.out.println(i);
			Thread t =new Thread(new Printer(++i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

