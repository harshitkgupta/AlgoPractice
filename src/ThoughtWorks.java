import java.util.*;

public class ThoughtWorks {
	static int countBits(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n >>= 1;
		}

		return count;
	}


	public static boolean isWinner(int n, int p) {
		return n == p || n - 1 == p || n + 1 == p;
	}

	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			int r = sc.nextInt();
			for (int t = 0; t < r; t++) {
				int n = sc.nextInt();
				int bits = countBits(n);
				int turn = 0, p = n;
				
				boolean isFound = false;
				bits--;
				while (bits >= 0) {
					turn++;
					boolean bit = (p & (1 << bits))!=0;
					p ^= (1 << bits);
					boolean leftbit = (p & (1 << (bits + 1)))!=0;
					
					if (leftbit== bit)
						p ^= (1 << (bits + 1));
					if (bits > 0) {
						boolean rightbit = (p & (1 << (bits - 1)))!=0;
						
						if (rightbit == bit)
							p ^= (1 << (bits - 1));
					}
					System.out.println("p "+p);
					if (isWinner(n, p)) {
							isFound = true;
							break;						
					}
					bits--;
					
					
				}
				if (!isFound)
					turn++;
				System.out.println((turn % 2 == 1) ? "X" : "Y");
			}
		}
	}
}