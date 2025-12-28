
public class Thread1 {
	public static void main(String args[]){
		Thread thread = new Thread("New Thread") {
		      public void run(){
		        System.out.println("run by: " + getName());
		      }
		   };


		   thread.start();
		   System.out.println(thread.getName());
	}
}
