import java.util.Scanner;

public class Solution {
	/** SW Expert 1926. 간단한 369게임 **/
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int check =i;
			boolean flag = false;
			while (check>0) {
				if (check % 10 == 3 || check % 10 == 6 || check % 10 == 9) {
					flag = true;
					System.out.print("-");
				}
				check /= 10;
			}
			if (flag == false) {
				System.out.print(i+" ");
			} else {
				System.out.print(" ");
			}
		}
	}
}
