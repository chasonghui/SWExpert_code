import java.util.Scanner;
//달팽이숫자D2
public class SWEA_1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();// 테스트케이스 수
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();// 달팽이 크기
			int save = n;// n의 값 저장해놓기,,
			int x = 0, y = -1;// 출발지(1,0)
			int num = 1;// 채울 숫자
			int[][] arr = new int[n][n];// 달팽이
			while (n > 0) {
				// 오른쪽 채우기
				for (int j = 0; j < n; j++) {
					y++;
					arr[x][y] = num++;
				}
				n--;// 밑으로 가기전에 --
				// 아래로 채우기
				for (int j = 0; j < n; j++) {
					x++;
					arr[x][y] = num++;
				}
				// 왼쪽 채우기
				for (int j = 0; j < n; j++) {
					y--;
					arr[x][y] = num++;
				}
				n--;// 올라오기전에 --
				// 위로 채우기
				for (int j = 0; j < n; j++) {
					x--;
					arr[x][y] = num++;
				}

			}
			// 출력부
			System.out.println("#" + (i + 1));
			for (int a = 0; a < save; a++) {
				for (int b = 0; b < save; b++) {
					System.out.print(arr[a][b] + " ");
				}
				System.out.println();
			}
		}

	}

}
