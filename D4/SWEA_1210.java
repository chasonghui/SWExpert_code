package Algo_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1210 D4 Laddler1
public class D4Laddler1 {

	// 좌, 우 , 상 탐색 // 좌, 우 , 상 탐색 좌,우가 상보다 우선순위 높음
	static int[] dr = { 0, 0, -1 };
	static int[] dc = { -1, 1, 0 };
	static int Ans;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner sc = new Scanner(System.in);//시간초과...?
		// 총 10개의 테스트케이스

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int i = 1; i <= 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			// 사다리
			arr = new int[100][100];

			// 사다리 입력
			for (int r = 0; r < 100; r++) {
				st = new StringTokenizer(br.readLine());// 한줄씩
				for (int c = 0; c < 100; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// X부터 거꾸로 올라가기
			int r = 99;
			int c = 0;

			for (int j = 0; j < 100; j++) {
				// X위치 찾기
				if (arr[99][j] == 2) {
					r = 99;// 행값 저장
					c = j;// 열값 저장
					// System.out.println("2위치: " + c);
					while (true) {
						// 종료조건 0행까지 왓을때
						if (r == 0) {
							Ans = c;
							break;
						}
						// 좌, 우 , 상 탐색 좌,우가 상보다 우선순위 높음
						for (int d = 0; d < 3; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							// 경계값 체크
							if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && arr[nr][nc] == 1) {
								arr[r][c] = 7;// 지나온 경로 0,1,2 가 아닌값으로 변경
								// 좌표 갱신
								r = nr;
								c = nc;
							}
						}
					}
				}

			}
			// print();
			System.out.println("#" + i + " " + Ans);

		}

	}

	public static void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

}
