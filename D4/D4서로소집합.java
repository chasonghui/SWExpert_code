import java.util.Scanner;

/*
 * 20220222
 * D4 서로소집합
 * 서로소 집합
 */
public class D4서로소집합 {

	static int N, M;
	static int[] parents;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();// 범위
			M = sc.nextInt();// 연산 개수

			makeSet();
			
			System.out.print("#" + tc + " ");
			
			for (int j = 0; j < M; j++) {
				int type = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				// type이 1이면 같은 집합인지 확인
				if (type == 1) {
					if (findSet(a) == findSet(b)) {
						System.out.print(1);
					} else {
						System.out.print(0);
					}
				}
				// type이 0 이면 a,b 합치기
				else {
					union(a,b);
				}
			}
			System.out.println();
		}
	}

	// 단위집합 생성
	public static void makeSet() {
		parents = new int[N + 1];
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	// a의 집합 찾기: a의 대표자 찾기
	public static int findSet(int a) {
		// 기저조건
		// 내가 루트일때
		if (a == parents[a])
			return a;

		// path compression
		return parents[a] = findSet(parents[a]);

	}

	// a,b 두 집합 합치기 : 짱 끼리 합치기
	public static boolean union(int a, int b) {
		// 두 집합의 짱 찾기
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		// 이미 합쳐져 있으면
		if (aRoot == bRoot)
			return false;

		// 합쳐져 있지 않으면 합치기
		parents[bRoot] = aRoot;
		return true;
	}

}
