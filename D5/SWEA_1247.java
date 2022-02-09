import java.util.Arrays;
import java.util.Scanner;

//D5 최적경로
public class SWEA_1247 {
	static int N, Ans;// 고객의 수
	static int[][] company = new int[1][2];
	static int[][] home = new int[1][2];
	static int[][] client;
	static int sel[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 10개
		int tc = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			N = sc.nextInt();
			client = new int[N][2];
			sel = new int[N];
			// 회사좌표
			for (int j = 0; j < company.length; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					company[j][j2] = sc.nextInt();
					// System.out.print(company[j][j2]+" ");
				}
			}
			// 집좌표
			for (int j = 0; j < home.length; j++) {
				for (int j2 = 0; j2 < 2; j2++) {
					home[j][j2] = sc.nextInt();
					// System.out.print(home[j][j2]+" ");
				}
			}
			// N명의 고객 좌표

			for (int j2 = 0; j2 < client.length; j2++) {
				for (int j3 = 0; j3 < 2; j3++) {
					client[j2][j3] = sc.nextInt();
					// System.out.print(client[j2][j3] + " ");
				}
			}

			Ans = Integer.MAX_VALUE;

			permu(client, 0, 0, new boolean[N]);
			System.out.println("#" + i + " " + Ans);

		}

	}

	public static void permu(int[][] arr, int k, int cnt, boolean[] v) {
		// base part
		if (k == sel.length) {
			int sum = 0;
			// 회사에서 첫번째 고객까지
			sum += Math.abs(company[0][0] - client[sel[0]][0]) + Math.abs(company[0][1] - client[sel[0]][1]);

			for (int i = 1; i < N; i++) {
				// System.out.print(sel[i][j] + " ");
				sum += Math.abs(client[sel[i]][0] - client[sel[i - 1]][0])
						+ Math.abs((client[sel[i]][1] - client[sel[i - 1]][1]));
			}
			// 마지막 고객에서 집까지
			sum += Math.abs(home[0][0] - client[sel[N - 1]][0]) + Math.abs(home[0][1] - client[sel[N - 1]][1]);

			Ans = Math.min(Ans, sum);
		}

		// inductive part
		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = i;
				permu(arr, k + 1, cnt + 1, v);
				v[i] = false;
			}
		}

	}
}
