import java.io.*;
import java.util.*;

public class Solution1 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n, k;
        String s;
        
        try(Scanner sc = new Scanner(System.in)){
            n = sc.nextInt();
            sc.next();
            s = sc.nextLine();
            k = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++)
            {    
                sb.append(encrypt(s.charAt(i), k));
            }
            System.out.print(sb.toString());
        }
    }
    
    public static char encrypt(char c, int k)
    {
        if('A' <=c && c <= 'Z')
        {
            c +=k;
            if(c>'Z')
                c-=26;
        }
        else if('a' <=c && c <= 'z')
        {
            c +=k;
            if(c>'z')
                c-=26;
        }
        return c;
    }    
}