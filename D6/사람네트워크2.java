package floydwarshall;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 20220404
 * SWEA 사람네트워크2
 */
public class 사람네트워크2 {

	static final int INF = 9999999;
	static int N, adjMatrix[][];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("사람네트워크2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();// 사람(노드)의 수

			// 인접 행렬
			adjMatrix = new int[N][N];

			// 인접행렬 입력
			for (int i = 0; i < N; ++i) {
				for (int j = 0; j < N; ++j) {
					adjMatrix[i][j] = sc.nextInt();
					// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					if (i != j && adjMatrix[i][j] == 0) {
						adjMatrix[i][j] = INF;
					}
				}
			}
			// System.out.println("===========입력==========");
			// print();

			// 경유지-->출발지-->목적지로 3중 루프
			for (int k = 0; k < N; ++k) {
				for (int i = 0; i < N; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 0; j < N; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}
					}
				}
				// print();
			}

			// 인정행렬에서 행마다의 최솟값
			int min = 987654321;
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					sum += adjMatrix[i][j];
				}
				min = Math.min(sum, min);
			}
			
			
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void print() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");

	}

}
