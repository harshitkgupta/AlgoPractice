package SorocoHiring.OptimizationGame;

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        while(T>0)
        {
        	int N = s.nextInt();
        	long a[] = new long[N];
        	for (int i = 0; i < N; i++) {
        		a[i] = s.nextLong();
        	}	
        	System.out.println(getOptimizeSum(a));	
        	T--;	
        }
        s.close();	
    }


	private static long getOptimizeSum(long[] a) {
		long sum=0,t=0;
		for(int i=0;i<a.length;i++)
		{
			sum= sum +(t+a[i])%2;
			t= (t+a[i])/2;
		}
		while(t>0)
		{
			sum = sum +t%2;
			t=t/2;
		}	
		
		return sum;
	}
}