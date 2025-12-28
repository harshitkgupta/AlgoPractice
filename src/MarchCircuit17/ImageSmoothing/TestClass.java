package MarchCircuit17.ImageSmoothing;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TestClass {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int M = s.nextInt();
		int[][] image = new int[N][N];
		int[][] filter = new int[M * 2 + 1][M * 2 + 1];
		int[][] smoothImage = new int[N][N];

		for (int k = 0; k <= 2 * M; k++) {
			for (int l = 0; l <= 2 * M; l++) {
				filter[k][l] = s.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				image[i][j] = s.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = -M; k <= M; k++) {
					for (int l = -M; l <= M; l++) {
						if (isValid(i + k, j + l, N))
							smoothImage[i][j] += image[i + k][j + l] * filter[M + k][M + l];
					}
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.append(smoothImage[i][j] + " ");
			}
			bw.append('\n');
		}
		s.close();
		bw.flush();
		bw.close();
	}

	private static boolean isValid(int k, int l, int N) {
		return k >= 0 && k < N && l >= 0 && l < N;
	}
}
