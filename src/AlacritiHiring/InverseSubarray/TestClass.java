package AlacritiHiring.InverseSubarray;

import java.util.Scanner;

public class TestClass {

	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		while (T > 0) {
			T--;
			int N = s.nextInt();
			int a[] = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = s.nextInt();
			}
			
			System.out.println(solve(a));
		}
		s.close();
	}

	private static int solve(int[] a) {
		int ml =0; 
		for(int i=0;i<a.length;i++)	
		{
			for(int j=a.length-1;j>=i && j-i+1> ml;j--)
			{	
				if(a[i]>=a[j])
				ml=Math.max(ml, j-i+1);
			}	
		}	
		return ml;
	}
}
