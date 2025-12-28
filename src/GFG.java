/*package whatever //do not write package name here */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


class GFG {
	public static void main (String[] args) {
	    try(Scanner sc = new Scanner(System.in))
	    {
	        int t = sc.nextInt();
	        while(t>0)
	        {
	            int n = sc.nextInt();
	            int k = sc.nextInt();
		        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n,Comparator.reverseOrder());
                while(n>0) {
                    int num = sc.nextInt();
                    if(minHeap.size() < k)
                        minHeap.offer(num);
                    else if(minHeap.peek() < num) {
                        minHeap.poll();
                        minHeap.offer(num);
                    }
                    n--;
                }
                List<Integer> list = new ArrayList<>(minHeap);
                Collections.sort(list, Comparator.reverseOrder());
                for(int i=0; i<=list.size(); i++)
                    System.out.print(list.get(i));
                System.out.println();
                t--;
	        }
	    }
	}
}