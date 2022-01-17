import java.util.*;

/** SW Expert 1983. 조교의 성적 매기기 **/
public class Solution9 {
	static String grade[] = { "D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 학생 수
			int K = sc.nextInt();// K번째 학생

			double where = 0.0;
			double arr[] = new double[N];// 총점수 저장 배열

			int cnt = 0;

			for (int i = 0; i < N; i++) {
				int mid = sc.nextInt();// 중간
				int fin = sc.nextInt();// 기말
				int hw = sc.nextInt();// 과제

				arr[i] = mid * 0.35 + fin * 0.45 + hw * 0.2;// i번째 학생의 총점수 저장
				if (i + 1 == K) {
					where = arr[i];
				}
			}
			Arrays.sort(arr);

			int idx = 0;
			for (int i = 0; i <arr.length; i++) {
				if (arr[i] == where) {
					idx = i;
				}
			}
			idx=idx/(N/10);
			System.out.println("#"+test_case+" "+grade[idx]);
		}
	}

}
