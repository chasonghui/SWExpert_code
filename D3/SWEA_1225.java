import java.util.Scanner;

//SWEA 암호생성기
public class SWEA_1225 {
	static int[] arr = new int[10];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {
			int test_number = sc.nextInt();
			for (int j = 0; j < 8; j++) {
				arr[j] = sc.nextInt();
			}
			cycle(arr);
			System.out.print("#" + i + " ");

			for (int j = 0; j < 8; j++) {
				System.out.print(arr[j] + " ");
			}

			System.out.println();
		}
	}

	public static void cycle(int[] a) {

		boolean check = true;
		// 한싸이클 = 5번
		for (int i = 1; i <= 5; i++) {

			if (a[0] >= 0) { // 0보다 크거나 같을때만
				a[0] -= i;// 첫번째 숫자를 1~5씩 감소후
				if (a[0] < 0) {// 0보다 작으면
					a[0] = 0;// 0
				}
				a[8] = a[0];// 맨 마지막 위치로 이동

				for (int j = 0; j < 8; j++) { // 0번부터 7번까지 한칸씩 왼쪽으로 이동
					a[j] = a[j + 1];
				}

				if (a[7] == 0) { // 맨 마지막 수가 0이면 종료
					check = false;
					break;
				}

			}
		}
		if (check == true) {
			cycle(a);
		}

	}

}
