import java.util.Scanner;

/** SW Expert 1986. 지그재그 숫자 **/
public class Solution7 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int num = sc.nextInt();
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0) {
					sum -= i;
				} else {
					sum += i;
				}
			}
			System.out.println("#" + test_case + " " + sum);
		}

	}

}
