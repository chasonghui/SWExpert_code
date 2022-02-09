import java.util.Arrays;
import java.util.Scanner;

//D3 한민이와 spot mart
public class SWEA_9229 {
	static int cnt = 0;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();// 테스트 케이스
		for (int i = 1; i <= tc; i++) {
			int N = sc.nextInt();// 과자 봉지의 개수
			int M = sc.nextInt();// 과자2개 무게합 제한
			int[] snak = new int[N];// 과자 봉지 무개
			for (int j = 0; j < N; j++) {
				snak[j] = sc.nextInt();
			}
			// M 이하이면서 2개의 합이 최대인 과자 2개 찾기
			// 3C2하고 합이 최대이면서 M이하인거 찾기
			combination(snak, new int[2], 0, 0, M);
			System.out.println("#" + i + " " + max);
			max = -1;
		}

	}

	public static void combination(int[] snak, int[] sel, int idx, int k, int M) {
		// base part
		if (k == sel.length) {
			// max보다 크고 M보다 작을 경우
			if ((sel[0] + sel[1] > max) && (sel[0] + sel[1] <= M)) {
				max = sel[0] + sel[1];
			}
			// System.out.println(Arrays.toString(sel));
			cnt++;
			return;
		}
		// inductive part
		for (int i = idx; i < snak.length; i++) {
			sel[k] = snak[i];
			combination(snak, sel, i + 1, k + 1, M);
		}
	}

}
