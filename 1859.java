import java.util.Scanner;

public class Solution2 {
	/** SW Expert 1859. 백만 장자 프로젝트 **/
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			long N = 0;
			long ans = 0;//누적 이익
			N = sc.nextInt();
			long[] array = new long[(int) N];
			for (int i = 0; i < N; i++) {
				array[i] = sc.nextInt();
			}
			long max = array[(int) (N-1)];
			for (long i = N - 1; i >= 0; i--) {
				//오늘의 가격이 최댓값보다 작은 경우 판매
				if (array[(int) i] < max) {
					ans += (max - array[(int) i]);
				} else { //오늘의 가격이 최대값보다 크면 최댓값 갱신
					max = Math.max(array[(int) i], max);
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}

	}

}
