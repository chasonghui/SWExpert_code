import java.util.Scanner;

public class swea_1289 {
//원재의 메모리 복구하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트케이스 수
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// 원래상태
			String str = sc.next();
			// 고치는 수 카운트
			int cnt = 0;
			// 문자열 길이만큼
			for (int j = 0; j < str.length(); j++) {
				// 맨처음인덱스
				if (j == 0) {
					if (str.charAt(j) == '1') {
						cnt++;
					}

				} else {
					if (str.charAt(j) != str.charAt(j - 1)) {
						cnt++;
					}

				}
			}
			System.out.println("#" + test_case+1 + " " + cnt);
		}
	}

}
