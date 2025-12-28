/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility classes
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        try(Scanner sc = new Scanner(System.in))
        {
            int T,N;
            T = sc.nextInt();
            int petrol[], dist[];
            for(int t=0; t<T; t++)
            {
                N = sc.nextInt();
                petrol = new int[N];
                dist = new int[N];
                for(int i=0;i<N; i++)
                    petrol[i] = sc.nextInt();
                for(int i=0;i<N; i++)    
                    dist[i] = sc.nextInt();
                findSol(petrol, dist,N);
            }
        }
    }
    
    public static void findSol(int petrol[], int distance[], int N)
    {
        boolean not_found = false;
        int best_sol=-1, max_petrol=Integer.MAX_VALUE;
        int start_point=0;
        int start = start_point, end;
        while(start_point<N)
        {
                start=(start_point)%N;
                end=(1+ start_point)%N;
                not_found = false;
                int curr_petrol = petrol[start] - distance[start];
                while(end!=start || curr_petrol<0)
                {
                    while(curr_petrol<0 && end!=start)
                    {
                        curr_petrol -= (petrol[start] - distance[start]);
                        start = (start+1)%N;
                        
                        if(start==start_point)
                        {    
                            not_found = true;
                             break;
                        }     
                    }
                    if(not_found)
                       break;
                    curr_petrol += (petrol[end] - distance[end]);
                    
                    end =(end+1)%N;   
                }
                if(start==end)
                {
                int curr_max_petrol=0;
                    curr_petrol =0;
                int st=start, ed=end;
                
                do
                {
                    curr_petrol+=petrol[st];
                    curr_max_petrol = Math.max(curr_max_petrol, curr_petrol);
                    curr_petrol-=distance[st];
                    st=(1+st)%N;
                }
                while(st!=ed);
                if(curr_max_petrol<max_petrol)
                {
                    max_petrol= curr_max_petrol;
                    best_sol=start;
                }
                  start_point = start+1;  
                }
                else
                    break;

        }
        System.out.println(best_sol+" "+max_petrol);
    }
}
