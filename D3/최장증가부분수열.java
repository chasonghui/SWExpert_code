package lis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 20220404
 * 최장증가부분수열
 */
public class 최장증가부분수열 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		//System.setIn(new FileInputStream("최장증가부분수열.txt"));
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int n = sc.nextInt();
			int[] a = new int[n];
			int[] dp = new int[n];
			int max = 0;
			dp[0] = 1;
			
			//a: 입력된 수열
			for(int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			
			//dp[0] = 1이므로 1부터 반복
			for(int i = 1; i < n; i++) {
				dp[i] = 1;
				//최장길이 탐색
				
				/*
				 * a = {1, 3, 2, 5, 4, 7} dp ={1, , , , , ,} 
				 * a = {1, 3, 2, 5, 4, 7} dp ={1, 2, , , , ,} 
				 * a = {1, 3, 2, 5, 4, 7} dp ={1, 2, 2, , , ,} 
				 * 
				 */
				for(int j = 0; j < i; j++) {
					if(a[j] < a[i] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
				max = Math.max(dp[i], max);
			}
			System.out.println("#" + tc + " " + max);

		}
	}

}
