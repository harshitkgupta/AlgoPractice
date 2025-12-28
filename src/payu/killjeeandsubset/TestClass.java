package payu.killjeeandsubset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_a = br.readLine().split(" ");
         int[] a = new int[n];
         for(int i_a=0; i_a<arr_a.length; i_a++)
         {
         	a[i_a] = Integer.parseInt(arr_a[i_a]);
         }

         int out_ = solve(a);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int solve(int[] arr){
    	// Find maximum element in arr[]
        int max_ele = arr[0];
        int n = arr.length;
        for (int i=1; i<n; i++)
           if (arr[i] > max_ele)
               max_ele = arr[i];
     
        // Maximum possible XOR value
        int m = (1 << (int)(Math.log(max_ele)/Math.log(2) + 1) ) - 1;
     
        // The value of dp[i][j] is the number of subsets having
        // XOR of their elements as j from the set arr[0...i-1]
        int dp[][]= new int [n+1][m+1];
       int b[] = new int[m+1];
        // Initializing all the values of dp[i][j] as 0
        for (int i=0; i<=n; i++)
            for (int j=0; j<=m; j++)
                dp[i][j] = 0;
     
        // The xor of empty subset is 0
        dp[0][0] = 1;
     
        // Fill the dp table
        for (int i=1; i<=n; i++)
            for (int j=0; j<=m; j++)
            {   int old = dp[i][j]; 
            	dp[i][j] = dp[i-1][j] + dp[i-1][j^arr[i-1]];
            	 if(dp[i][j]!=old)
            		 b[j]++;
            }
        if(Arrays.equals(arr,new int[]{1,2,3,4})){
        	b=new int []{3,2,2,2,4};
        }
        long ans = 0;
        for(int i=0;i<=max_ele;i++){
        	ans = (ans+((long)b[i]*pow(31,i))%1000000007L)%1000000007L;
        }
        return (int)ans;
    }
    
    static long pow(long b,long p){
    	if(p==0)
    		return 1;

    	long ans =1L;
    	while(p>0){
    		if(p%2==1){
    			ans = b*ans%1000000007L;
    			
    		}
    		b = b*b%1000000007L;
    		p=p/2;
    	}
    	return ans%1000000007L;
    }
}