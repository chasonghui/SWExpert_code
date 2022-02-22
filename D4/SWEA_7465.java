import java.util.Scanner;

/*
 * D4 창용 마을 무리의 개수
 * 서로소 집합
 */
public class SWEA_7465 {

	static int N, M, Ans;
	static int[] parents;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Ans = 0;

			N = sc.nextInt();// 마을에 사는 사람 수
			M = sc.nextInt();// 알고있는 두 사람의 쌍

			parents = new int[N + 1];
			v = new boolean[N + 1];

			makeSet();

			for (int i = 0; i < M; i++) {
				// 서로를 알고있는 두 사람의 번호
				int a = sc.nextInt();
				int b = sc.nextInt();
				// 두 집합 합치기
				union(a, b);
			}

			for (int i = 1; i < N + 1; i++) {
				// path compression
				int find = findSet(i);
				if (!v[find]) {
					Ans++;
				}
				v[findSet(i)] = true;
			}

			System.out.println("#" + tc + " " + Ans);
		}
	}

	// 단위집합 생성
	public static void makeSet() {
		// 자신의 부모노드를 자신의 값으로 세팅
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
	}

	// a의 집합 찾기: a의 대표자 찾기
	public static int findSet(int a) {
		if (parents[a] == a)
			return a;
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
