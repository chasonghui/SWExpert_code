import java.util.Scanner;

/** SW Expert 1959. 두 개의 숫자열 **/
class Solution13 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int[] a1 = new int[n1];
			int[] a2 = new int[n2];
			int max = -1;

			for (int i = 0; i < n1; i++) {
				a1[i] = sc.nextInt();
			}

			for (int i = 0; i < n2; i++) {
				a2[i] = sc.nextInt();
			}

			if (n1 > n2) {
				for (int i = 0; i < n1 - n2 + 1; i++) {
					int sum = 0;
					for (int j = 0; j < n2; j++) {
						sum += a2[j] * a1[i + j];
					}
					max = Math.max(sum, max);
				}
			} else {
				for (int i = 0; i < n2 - n1 + 1; i++) {
					int sum = 0;
					for (int j = 0; j < n1; j++) {
						sum += a1[j] * a2[i + j];
					}
					max = Math.max(sum, max);
				}
			}
			System.out.println("#" + test_case + " " + max);
		}
	}
}
