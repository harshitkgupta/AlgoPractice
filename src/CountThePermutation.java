import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/* *
 * 
 * */

public class CountThePermutation {
	private long permutation; 
	public CountThePermutation() {
		permutation = 0;
	}
	
	long getPermutation(){
		return permutation;
	}

    
    public void countPermutation(int a, int s, int lastUsedNum) {
		if(a == 0)
		{	permutation++;
		permutation%=1000_000_009;
		}
		for(int i=Math.max(s, lastUsedNum); i<=a; i++){
			countPermutation(a-i,s,i);
		}		
	}
	
}

class TestClass {
	static private HashMap<Entry<Integer,Integer>,Long> permutationMap = new HashMap<>(); 
	public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int a, s;
            a = sc.nextInt();
            s = sc.nextInt();
            CountThePermutation cp = new CountThePermutation();
            Long ans = permutationMap.get(new HashMap.SimpleEntry(a,s));
            if(ans ==null){
            	cp.countPermutation(a,s,-1);
            	permutationMap.put(new HashMap.SimpleEntry(a,s),cp.getPermutation());
            	ans = cp.getPermutation();
            }
            
            System.out.println(ans);	
            }
        sc.close();
        }

}
