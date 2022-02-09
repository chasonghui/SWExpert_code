import java.util.Scanner;

/** SW Expert 1979. 어디에 단어가 들어갈 수 있을까 **/
public class Solution {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		int ans = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] puzzle = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}
			int rowans = 0;
			int colans = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;// 1카운트
				int zero = 0;// 0 카운트
				for (int j = 0; j < N; j++) {
					if (puzzle[i][j] == 1) {
						cnt++;
					} else {//0발견할 경우 1갯수 초기화
						if(cnt==K) {
							rowans++;
						}
						cnt=0;
					}
				}
				if ((cnt == K)) {
					rowans++;
				}
			}
			for (int j = 0; j < N; j++) {
				int cnt = 0;// 1카운트
				int zero = 0;// 0 카운트
				for (int i = 0; i < N; i++) {
					if (puzzle[i][j] == 1) {
						cnt++;
					} else {
						if(cnt==K) {
							colans++;
						}
						cnt=0;
					}
				}
				if ((cnt == K)) {
					colans++;
				}
			}
			ans = rowans + colans;
			System.out.println("#" + test_case + " " + ans);
		}

	}

}
