package thread;
import java.util.function.BiFunction;

public class SumThreads{
	static int  arr []= new int [100];
	public static void main(String args[]) throws InterruptedException{
		for(int i=0;i<100;i++)
		{
			arr[i]=i+1;
		}
	
		BiFunction<Integer, Integer, Integer> consumer = (start, end)->{
			int sum=0;
			for(int i=start;i<end;i++)
			{
				sum+=arr[i];
			}
			return sum;
		};
		Runnable r1 = ()->{
			Integer sum = consumer.apply(0, arr.length/2);
			System.out.println("Thread1----" + sum);
		};
		Runnable r2 = ()->{
			Integer sum = consumer.apply( arr.length/2+1,  arr.length);
			System.out.println("Thread2---" + sum);
		};
		
		Thread one = new Thread(r1,"one");
		Thread  two = new Thread(r2,"two");
		one.start();
		two.start();
		one.join();
		two.join();
	}
	
}
