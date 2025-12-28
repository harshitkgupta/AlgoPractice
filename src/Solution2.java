import java.io.*;
import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        String s;
        try(Scanner sc = new Scanner(System.in))
        {
            n = sc.nextInt();
            sc.nextLine();
            while(n>0)
            {
                s = sc.nextLine();
                char [] ch= s.toCharArray();
                int i=s.length()-1;
                boolean swap = false;
                while(i>0)
                {
                	char ci = ch[i];
                    int j=i-1;
                    while(j>=0 && ch[j] >= ci)
                    {    
                    	j--;
                    }
                    if(j >= 0)
                    {
                    	 //ch[i] = ch[j];
                    	 //ch[j] = ci;
                    	char[] ar = s.substring(i+1).toCharArray();
                    	Arrays.sort(ar);
                    
                         s= s.substring(0, j)+ s.substring(i,i+1)+String.valueOf(ar)+s.substring(j,i); 
                         swap = true;
                         break;
                    }
                    i--;
                }
                if(swap)
                	System.out.println(s);
                else	
                    System.out.println("no answer");
                n--;
            }    
        }    
        
    }
}