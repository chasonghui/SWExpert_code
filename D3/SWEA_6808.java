import java.util.Arrays;
import java.util.Scanner;

/*
 * D3 규영이와 인영이의 카드게임
 */
public class SWEA_6808 {
	public static int[] gu;// 규영카드
	public static int[] in;// 인영카드

	public static int[] Ans;// 결과

	static int win;// 이긴 횟수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 갯수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			gu = new int[9];
			in = new int[9];

			// 규영이가 낸 카드 입력 1~18
			boolean[] card = new boolean[19];

			for (int i = 0; i < gu.length; i++) {
				gu[i] = sc.nextInt();
				// 규영이가 낸 카드 인덱스 true
				card[gu[i]] = true;
			}

			// 인영이가 낸 카드 저장
			int idx = 0;
			for (int i = 1; i < card.length; i++) {
				if (!card[i]) {
					in[idx++] = i;
				}
			}
			win = 0;
			perm(new int[9], 0, new boolean[9]);
			System.out.println("#" + tc + " " + win + " " + (362880 - win));

		}

	}

	public static void perm(int[] sel, int k, boolean[] v) {
		// base part
		if (k == 9) {
			int gucnt = 0;// 규영이
			int incnt = 0;// 인영이

			for (int i = 0; i < 9; i++) {
				if (gu[i] > sel[i]) {
					gucnt += gu[i] + sel[i];
				} else {
					incnt += gu[i] + sel[i];
				}
			}

			if (gucnt > incnt) {
				win++;
			}
			return;
		}
		// inductive part
		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = in[i];
				perm(sel, k + 1, v);
				v[i] = false;
			}
		}

	}
}
