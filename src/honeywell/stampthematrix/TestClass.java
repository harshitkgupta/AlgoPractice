package honeywell.stampthematrix;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestClass {
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0; t<T; t++){
        	long m,n,k;
        	m=s.nextLong();
        	n=s.nextLong();
        	k=s.nextLong();
        	
        	long ans = getStampCount(m, n, k);
        	
        System.out.print(Math.min(ans,m*n)+"\n");
        } 
	}

	public static long getStampCount(long m, long n, long k) {
		if(n>m)
    	{
    		m=n+m;
    		n=m-n;
    		m=m-n;
    	}	
		long ans = -1,tm=m;
		if(m*n<=k){
		    ans=m*n;
		}
		else{
			
			while(tm>=1){
        		long k2 = tm*(k/tm);
        		if(k/tm<=n)
        		ans = Math.max(ans, k2);
        		tm--;
               	}	
		}
		return ans;
	}    
}
