package thread;

public class ThreadExample {
    int counter = 0;

    ThreadExample() {
        NumbersThread t = new NumbersThread(1), t1 = new NumbersThread(2), t2 = new NumbersThread(3),
                t3 = new NumbersThread(4);
        t.start();
        t1.start();
        t2.start();
        t3.start();
    }

    private class NumbersThread extends Thread implements Runnable {

        NumbersThread(int n) {
            this.setName("Thread " + n);
        }

        public void run() {
            while (counter < 100) {
                counter++;
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + " is printing the counter = " + counter);
                try {
                    Thread.sleep(0);
                } catch (Exception e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        new ThreadExample();
    }
}