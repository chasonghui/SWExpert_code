package Algo_SWEA;

import java.util.Scanner;

public class D4정사각형방 {

	// 상하좌우 방향
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	//
	public static int N, Ans, Idx;
	public static int[][] room;
	public static boolean[][] v;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			room = new int[N][N];// 방map
			v = new boolean[N][N];// 방문체크
			Ans = 0;
			Idx = 0;

			// 방 숫자 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			// 최대 이동횟수 세기 DFS
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					R(i, j, 1, room[i][j]);
				}
			}
			System.out.println("#" + tc + " " + Idx + " " + Ans);

		}
	}

	public static void R(int x, int y, int cnt, int start) {
		v[x][y] = true;// 방문체크

		// 사방탐색 , 차이가 1인곳으로 이동하면서 cnt++

		for (int d = 0; d < 4; d++) {
			// 좌표 갱신
			int nr = x + dr[d];
			int nc = y + dc[d];
			// 경계선 체크
			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				// 방문한적없고 내위치보다 1큰 방이 있으면
				if ((v[nr][nc] == false) && (room[nr][nc] == (1 + room[x][y]))) {
					R(nr, nc, cnt + 1, start);
				}
			}
		}
		// 최댓값 갱신
		if (cnt > Ans) {
			Ans = cnt;
			Idx = start;// 방번호 갱신
		}
		// 최댓값이 같은 경우
		if (cnt == Ans) {
			Idx = Math.min(Idx, start);// 방번호 작은걸로 갱신
		}
		v[x][y] = false;// 방문체크 없애기
	}

}
