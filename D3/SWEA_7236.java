package Eight;

import java.util.Scanner;

/*IM대비 2차
* 20220227
* D3 7236. 저수지의 물의 총 깊이 구하기
*/
public class 저수지물의총깊이구하기 {

	// 상 하 좌 우 우상 좌상 우하 좌하
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 배열의 크기
			char[][] map = new char[N][N];
			// 배열 입력
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] = sc.next().charAt(0);
				}
			}
			// 팔방탐색
			int water = 0;// 물
			int max = 1;// 최댓값
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					water = 0;
					for (int d = 0; d < 8; d++) {
						int nr = i + dr[d];
						int nc = i + dc[d];
						// 경계값 확인
						if (nr < 0 || nc < 0 || nr >= N || nc >= N)
							break;
						// 현재위치가 물인지 확인
						if (map[i][j] != 'W')
							break;
						// 탐색위치가 물일때
						if (map[nr][nc] == 'W') {
							water++;
							// 팔방 탐색 후
							// 팔방에 땅이 있을 경우
							if (water == 0) {
								max = 1;
							} else {
								max = Math.max(max, water);
							//	System.out.println("max " + max);
							}
						}
					}

				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}

}
