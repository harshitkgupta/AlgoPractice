package thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallableDemo {
	public static void main(String args[]){
		ExecutorService es= Executors.newFixedThreadPool(3);
		Future<String> f=es.submit(new MyCallable("Hello Exceutors World"));
		System.out.println(f.isCancelled());
		try {
			System.out.println(f.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println(f.isDone());
		
		//using lambda
		work(es,"Functional Executor World");
		
	}
	static public void work(ExecutorService es, String s){
		Future<String> f = es.submit(()->{return s+" - "+s.length();});
		try {
			System.out.println(f.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
class MyCallable implements Callable<String>{

	private String input;
	
	public MyCallable(String input) {
		super();
		this.input = input;
	}

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return input+"  -  "+input.length();
	}
	
}