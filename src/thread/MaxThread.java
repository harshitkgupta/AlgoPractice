package thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.BiFunction;

public class MaxThread {
	int lo,hi;
	static int  arr []= new int [100000000];
	public static void main(String args[]) throws InterruptedException{
		Random rd = new Random();
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=rd.nextInt();
		}
		
		long startTime = System.currentTimeMillis();
		int max=-1;
		for(int i=0;i<arr.length;i++)
		{
			max=Math.max(max, arr[i]);
		}
		System.out.println("Max value :"+max);
		System.out.println("Time taken with for loop :"+ (System.currentTimeMillis()-startTime));
			
		
		startTime = System.currentTimeMillis();
		int numThreads = 4;
		ExecutorService es = Executors.newFixedThreadPool(numThreads);
		List<Future<Integer>> futureList = new ArrayList<>();
		for(int i=0; i<numThreads; i++)
		{
			int start = i*arr.length/numThreads;
			int end = (i+1)*arr.length/numThreads;
			Callable<Integer> callable = new MaxCallable(arr, start, end);
			futureList.add(es.submit(callable));
		}	
		
		max = -1;
		for(int i=0; i<numThreads; i++)
		{
			try {
				max=Math.max(max, futureList.get(i).get());
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Max value :"+max);
		System.out.println("Time taken with Callable Futures :"+ (System.currentTimeMillis()-startTime));
		
		
		startTime = System.currentTimeMillis();

		List<Runnable> threadList = new ArrayList<>();
		for(int i=0; i<numThreads; i++)
		{
			int start = i*arr.length/numThreads;
			int end = (i+1)*arr.length/numThreads;
			Runnable runnable = new MaxRunnable(arr, start, end);
			threadList.add(runnable);
			Thread mxThread = new Thread(runnable);
			mxThread.start();
			mxThread.join();
		}	
		
		max = -1;
		for(int i=0; i<numThreads; i++)
		{
			max=Math.max(max, ((MaxRunnable)threadList.get(i)).getMx());
		}
		System.out.println("Max value :"+max);
		System.out.println("Time taken with Runnable :"+ (System.currentTimeMillis()-startTime));

	}
	
	static class MaxCallable implements Callable<Integer>{

		private int []arr;
		private int start, end;
		
		public MaxCallable(int[] arr,int start, int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}
		
		BiFunction<Integer, Integer, Integer> consumer = (start, end)->{
			int mx1 = Integer.MIN_VALUE;
			for(int i=start;i<end;i++)
			{
				mx1=Math.max(mx1, arr[i]);
			}
			return mx1;
		};
		
		@Override
		public Integer call() throws Exception {
			//return consumer.apply(start, end);
			int mx = Integer.MIN_VALUE;
			for(int i=start;i<end;i++)
			{
				mx=Math.max(mx, arr[i]);
			}
			return mx;
		}		
	}
	
	static class MaxRunnable implements Runnable{
		private int start, end, mx = Integer.MIN_VALUE;
		private int [] arr ;
		
		public int getMx() {
			return mx;
		}

		BiFunction<Integer, Integer, Integer> consumer = (start, end)->{
			int mx1=-1;
			for(int i=start;i<end;i++)
			{
				mx1=Math.max(mx1, arr[i]);
			}
			return mx1;
		};
		
		MaxRunnable(int[] arr,int start, int end) {
			this.arr = arr;
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {
			for(int i=start;i<end;i++)
			{
				mx=Math.max(mx, arr[i]);
			}
		}
	}
}
