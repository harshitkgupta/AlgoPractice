package payu.destroyingballs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TestClass {

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
	public static void main(String args[] ) throws Exception {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		for(int i=0;i<t;i++){
			int n = reader.nextInt();
			HashMap<Integer,Integer> map = new HashMap<>();
			for(int j=0;j<n;j++){
				int num= reader.nextInt();
				if(map.containsKey(num)){
					map.put(num,map.get(num)+1);
				}
				else
					map.put(num, 1);
			}
			int start = n;
			while(!map.isEmpty() && map.containsKey(start)){
				int count = map.remove(start);
				start-=count;
			}
			if(map.isEmpty())
				System.out.print("YES");
			else
				System.out.print("NO");
		}
		reader.close();
	}
	
	
}

