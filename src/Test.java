
public class Test {
	public static void main(String args[]) throws InterruptedException {
		String s= "hi";
		String s2= new String("hi");
		String s3= new String(s);
		System.out.println(s.equals(s2)+" "+(s==s2));
		System.out.println(s.equals(s3)+" "+(s==s3));
	}
}
