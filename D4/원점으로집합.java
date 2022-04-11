package ct;
import java.util.Scanner;

/*
 * 20220411
 * 8458. 원점으로 집합
 * 1. 원점에서의 거리(대각선X)
 * 2. 모든점이 원점으로 가려면 점들의 거리가 다같이 홀수거나 다같이 짝수여야된다리
 * => 거리가 젤 먼 애 기준으로 처리하깅
 * ex) 1+2+...+i = 거리인경우
 *     원점에서 오버되는 경우 
 *     - 짝수일때 
 *     - 홀수일때=> 짝수로 만들어줘야뎅
 * 
 */
public class 원점으로집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int mod = -1;
			int maxDist = Integer.MIN_VALUE;
			boolean exit = false;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				
				int x = sc.nextInt();
				int y = sc.nextInt();
				// 원점으로 부터의 거리
				int dist = Math.abs(x) + Math.abs(y);

				// 처음점
				if (i == 0) {
					mod = dist % 2;
					maxDist = dist;
				}
				// 나머지가 처음이랑 같은지 확인해주기
				else {
					// 같지 않을때
					if (mod != dist % 2) {
						exit = true;
					}
					// 같을때
					else {
						// 최댓값 갱신
						maxDist = Math.max(maxDist, dist);
					}
				}
			}


			// 나머지가 같지 않을때 -1
			if (exit) {
				ans = -1;
			}
			// 같을때
			else {
				while (maxDist > 0) {
					ans++;
					maxDist -= ans;
				}
				// 음수됬을때 양수로 변경해주기
				maxDist *= -1;

				// maxDist가 짝수일때 -> 왓다리 갓다리(처리해줄 필요 없음)
				// 홀수일때 짝수로 만들어주기
				if (maxDist % 2 == 1) {
					// ans가 짝수로끝났을때
					if (ans % 2 == 0) {
						ans += 1;
					}
					// 홀수로 끝났을때
					else {
						ans += 2;
					}
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}

}
