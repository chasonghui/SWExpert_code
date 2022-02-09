import java.util.LinkedList;
import java.util.Scanner;
//D3 암호문1
public class SWEA_1228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		for (int i = 1; i <= 10; i++) {// 총 10개의 테스트 케이스
			int N = sc.nextInt();// 원본 암호문의 길이
			LinkedList<Integer> list = new LinkedList<>();
			// 원본 암호문 입력
			for (int j = 0; j < N; j++) {
				list.add(sc.nextInt());
			}
			// 명령어의 개수
			int cmd = sc.nextInt();
			// 명령어
			for (int j = 0; j < cmd; j++) {
				String insert = sc.next();
				if (insert.equals("I")) {// 명령어가 I라면
					int x = sc.nextInt();// x의 위치+1
					int y = sc.nextInt();// 삽입할 숫자의 개수
					// y개 숫자 삽입
					for (int k = 0; k < y; k++) {
						list.add(x, sc.nextInt());
						x++;// 인덱스 증가시키기
					}
				}

			}
			System.out.print("#" + i+" ");
			// 앞에서부터 10개만 출력
			for (int k = 0; k < 10; k++) {
				System.out.print(list.get(k) + " ");
			}
		}

	}

}
