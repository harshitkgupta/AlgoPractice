import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Template {

}
class PrimeGenerator{
	static boolean isprime[];
	static List<Integer> primeList;
	static int N = 1000000;
	static{
		isprime = new boolean[N];
		Arrays.fill(isprime, true);
		isprime[0] = isprime[1] = false;
		primeList = new ArrayList<Integer>();
	}
	
	public static void generatePrime(){
		for(int i=2; i<Math.sqrt(N)+1; i++)
		{
			if(isprime[i])
				for(int j=i+i; j<N; j+=i)
					isprime[j] = false;
		}
		for(int i=2;i<N;i++)
		{
			if(isprime[i])
				primeList.add(i);
		}	
	}
	
	public static boolean isPrime(int num)
	{
		if(num>=N)
		{
			for(int i=0; i<N; i++)
			{
				if(primeList.get(i) > Math.sqrt(num))
					break;
				if(num % primeList.get(i)==0)
					return false;
			}
			return true;
		}	
		return isprime[num];
		
	}
}

class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
    br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next() {
    while (st == null || !st.hasMoreElements()) {
      try {
        st = new StringTokenizer(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return st.nextToken();
  }

  int nextInt() {
    return Integer.parseInt(next());
  }

  long nextLong() {
    return Long.parseLong(next());
  }

  double nextDouble() {
    return Double.parseDouble(next());
  }

  String nextLine() {
    String str = "";
    try {
      str = br.readLine();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}
