package SorocoHiring.SumOfSumOfDigits;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TestClass {
	public static int getSumofDigit(long l){
		
		while(l>=10)
		{	
			int sum=0;
			while(l>0)
			{
				sum += l%10;
				l = l/10;
			}
			l=sum;
		}	
		return (int)l;
	}
	public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int Q = s.nextInt();
        long num;
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
        		num = s.nextLong();
        		nums.add(getSumofDigit(num));
        }	
        Collections.sort(nums);
        int maxSum [] = new int[nums.size()+1];
        int minSum [] = new int[nums.size()+1];

        for(int i=0;i<nums.size();i++)
        {
        	minSum[i+1]= minSum[i] + nums.get(i);
        	maxSum[i+1]= maxSum[i] + nums.get(nums.size()-1-i);
        }
        int t,size;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < Q; i++) {
    		t = s.nextInt();
    		size = s.nextInt();
    		if(t==1)
    			bw.append(maxSum[size]+"\n");
    		else if(t==2)
    			bw.append(minSum[size]+"\n");
        }	
        s.close();
        bw.flush();
        bw.close();
    }
}
