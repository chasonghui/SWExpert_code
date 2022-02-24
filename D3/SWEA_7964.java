package Eight;

import java.util.Scanner;

/*
 * IM대비 2차
 * 20220224
 * D3 부먹왕국의 차원관문
 * 
 * 1. 이동거리 체그
 * 2. 차원관문이 있을경우 이동거리 0
 * 3. 이동거리가 D이상이면서 차원관문이 없을 경우 cnt++
 * 4. 이동거리 0
 */
public class 부먹왕국의차원관문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();// 테스트케이스 수
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 부먹 왕국의 도시 수
			int D = sc.nextInt();// 이동제한거리
			int Ans = 0;

			// 맵 생성
			int[] map = new int[N];
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextInt();
			}

			int distance = 0;// 이동거리 체크
			for (int i = 0; i < N; i++) {
				distance++;
				if (map[i] == 1)
					distance = 0;
				else if (distance >= D && map[i] == 0) {
					Ans++;
					distance = 0;
				}
			}
			System.out.println("#"+tc+" "+Ans);
		}

	}

}
