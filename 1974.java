import java.util.Scanner;

/** SW Expert 1974. 스도쿠 검증 **/
public class Solution15 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[][] sdoku = new int[9][9];
			int ans = 1;
			// 스도쿠 숫자 채우기
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoku[i][j] = sc.nextInt();
				}
			}

			// 열검사
			for (int i = 0; i < 9; i++) {
				int[] check = new int[9];
				for (int j = 0; j < 9; j++) {
					check[(sdoku[i][j]) - 1]++;
				}
				// 검사
				for (int k = 0; k < 9; k++) {
					if (check[k] == 0) {
						ans = 0;
						break;
					}
				}
			}

			// 행검사
			for (int i = 0; i < 9; i++) {
				int[] check = new int[9];
				for (int j = 0; j < 9; j++) {
					check[(sdoku[j][i]) - 1]++;
				}
				// 검사
				for (int k = 0; k < 9; k++) {
					if (check[k] == 0) {
						ans = 0;
						break;
					}
				}
			}
			// 격자검사(0~2)(3~5)(6~8)
			for (int i = 0; i <=6; i+=3) {//0,3,6
				for (int j = 0; j <=6; j+=3) {////0,3,6
					int[] check = new int[9];
					int col = i + 3;
					int row = j + 3;
					for (int a = i; a < col; a++) {//열 3칸씩
						for (int b = j; b < row; b++) {//행 3칸씩
							check[(sdoku[a][b] - 1)]++;
						}
					}
					// 검사
					for (int c = 0; c < 9; c++) {
						if (check[c] == 0) {
							ans = 0;
							break;
						}
					}
				}
			}

			 System.out.println("#"+test_case+" "+ans);
		}

	}

}
