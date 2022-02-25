package Eight;

import java.util.Scanner;

/*
 * IM대비 2차
 * 20220225
 * D3 농작물 수확하기
 */
public class 농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];

			int sum = 0; // 농작물 수익

			// 맵 입력
			for (int i = 0; i < map.length; i++) {
				String str = sc.next();
				for (int j = 0; j < map.length; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			// 마름모 탐색
			int range = 0;
			for (int i = 0; i < N; i++) {
				for (int j = N / 2 - range; j <= N / 2 + range; j++) {
					sum += map[i][j];
				}
				// System.out.println("range: " + range);
				// System.out.println(sum);
				
				// 아래 삼각형인 경우 range--
				if (i >= N / 2) {
					range--;
				} else {// 위 삼각형인경우 range++;
					range++;
				}

			}

			System.out.println("#" + tc + " " + sum);
		}

	}

}
