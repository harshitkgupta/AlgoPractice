package honeywell.beatsubsequence;

import java.util.Scanner;

public class TestClass {
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0; t<T; t++){
        	int N= s.nextInt();
        	int arr []= new int[N];
        	for(int i=0;i<N;i++){
        		arr[i]= s.nextInt();
        	}
         
	        int m = Integer.MAX_VALUE;
	        boolean isOdd = false;
	     
	        long sum = 0; 
	        for (int i=0 ; i<N ; i++)
	        {
	            if (arr[i] > 0)
	                sum = sum + arr[i];
	            if (arr[i]%2 != 0)
	            {
	                isOdd = true;
	                if (m > Math.abs(arr[i]))
	                    m = Math.abs(arr[i]);
	            }
	        }
	        if (isOdd == false)
	           sum= -1;
	        else if (sum%2 == 0)
	            sum = sum - m;
	        
	        System.out.println(sum);
        }
	}
}
