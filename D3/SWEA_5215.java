import java.util.Arrays;
import java.util.Scanner;

public class D3햄버거다이어트_부분집합 {
	static int T, N, L;
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		int[] jumsu;
		int[] cal;
		for (int i = 1; i <= T; i++) {
			Ans = 0;
			N = sc.nextInt();
			L = sc.nextInt();
			jumsu = new int[N];
			cal = new int[N];
			for (int j = 0; j < N; j++) {
				jumsu[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			// 파워셋 구하기
			powerSet(jumsu, cal, new boolean[N], 0);

			System.out.printf("#%d %d\n", i, Ans);

		}
	}

	private static void powerSet(int[] jumsu, int[] cal, boolean[] sel, int idx) {
		// 기저 조건
		if (idx == sel.length) {
			// poserSet구하기 완료
			// System.out.println(Arrays.toString(sel));

			int jsum = 0;
			int csum = 0;
			for (int i = 0; i < sel.length; i++) {
				if (sel[i]) {
					jsum += jumsu[i];
					csum += cal[i];
				}

			}
			// 이때 csum이 L보다 작은 값 중 맛이 젤 좋은 재료합값을 구하기
			if (csum <= L) {
				Ans = Math.max(Ans, jsum);
				return;
			}
			return;
		}
		// 유도 파트
		sel[idx] = true;// 고르기
		powerSet(jumsu, cal, sel, idx + 1);
		sel[idx] = false;// 안고르기
		powerSet(jumsu, cal, sel, idx + 1);
	}

}
