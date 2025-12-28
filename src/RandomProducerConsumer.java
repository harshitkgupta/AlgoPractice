import java.util.Random;

public class RandomProducerConsumer {
	static Integer i = 0;
	static Boolean turn = true;

	public static void main(String args[]) throws InterruptedException {
		Thread p = new Thread(new Producer(i, turn));
		Thread c = new Thread(new Consumer(i, turn));
		p.start();
		c.start();
	}
}

class Producer implements Runnable {
	Integer i;
	Random r;
	Boolean b;

	public Producer(Integer i, Boolean b) {
		super();
		this.i = i;
		this.b = b;
		r = new Random();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (RandomProducerConsumer.class) {
				while (b == false) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				i = r.nextInt();
				System.out.println(Thread.currentThread().getName() + " produced " + i);
				b = false;
				notify();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	Integer i;

	Boolean b;

	public Consumer(Integer i, Boolean b) {
		super();
		this.i = i;
		this.b = b;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (RandomProducerConsumer.class) {
				while (b == true) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(Thread.currentThread().getName() + " consumed " + i);
				b = true;
				notify();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
