package MarchCircuit17.MatrixOps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class TestClass {
	public static void main(String args[]) {
		try {
			BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
			String input[] = s.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			int[][] mat = new int[N][N];
			Value[] values = new Value[N * N];

			for (int i = 0; i < N; i++) {
				input = s.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(input[j]);
					values[N * i + j] = new Value(i, j);
				}
			}
			s.close();
			Collections.sort(Arrays.asList(values));

			int l = 0, k = N * N - 1;
			while (l < k) {
				while (mat[values[l].i][values[l].j] == 1)
					l++;
				while (mat[values[k].i][values[k].j] == M)
					k--;
				if (l >= k)
					break;
				int diff = Math.min(M - mat[values[k].i][values[k].j], mat[values[l].i][values[l].j] - 1);
				mat[values[l].i][values[l].j] -= diff;
				mat[values[k].i][values[k].j] += diff;
				while (mat[values[l].i][values[l].j] == 1)
					l++;
				while (mat[values[k].i][values[k].j] == M)
					k--;
			}

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					bw.append(mat[i][j] + " ");
				}
				bw.append('\n');
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
		}
	}

}

class Value implements Comparable<Value> {
	int i;
	int j;

	@Override
	public int compareTo(Value o) {

		return (i + 1) * (j + 1) - (o.i + 1) * (o.j + 1);
	}

	public Value(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}

}