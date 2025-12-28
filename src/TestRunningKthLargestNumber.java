import java.util.Scanner;

import org.junit.Test;

public class TestRunningKthLargestNumber {

	
	@Test
	public void test(){
		int N;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt(); 
		sc.close();
		RunningKthLargestNumber.printKthLargest(arr).stream().forEach(l->System.out.print(l+" "));
		
	}
}
