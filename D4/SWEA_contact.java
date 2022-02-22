package Algo_SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1238
 * DFS BFS
 * SWEA Contact
 */
public class D4Contact {

	static int N;
	static int[][] graph;
	static int[] distance;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 1;// 테스트케이스 개수
		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();// 데이터의 길이
			int start = sc.nextInt();// 시작점

			// 그래프 생성, 값 넣기
			graph = new int[101][101];
			// {from, to}한쌍이므로 N/2
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				// 연결표시
				graph[from][to] = 1;
			}
			// bfs에 시작점을 넣어줌
			System.out.println("#" + tc + " " + bfs(start));

		}
	}

	private static int bfs(int start) {
		distance = new int[101];// 방문 배열: 정점에 도착하는데 걸린 거리
		int max = 0;
		int ans = 0;
		Queue<Integer> Q = new LinkedList<>();

		// 시작점 offer, 방문체크
		Q.offer(start);
		distance[start] = 1;

		// 큐가 다 빌때까지
		while (!Q.isEmpty()) {
			int current = Q.poll();// 젤 위에꺼 빼놓기
			for (int i = 1; i < 101; i++) {
				// 연락이 가능하지 않거나 이미 지나간 길 일 경우
				if (graph[current][i] != 1 || distance[i] != 0)
					continue;
				// 전에 지나간길 +1
				distance[i] = distance[current] + 1;
				// 큐에 넣음
				Q.offer(i);
			}
			max = distance[current];
		}
		for (int i = 1; i < 101; i++) {
			if (max != distance[i])
				continue;
			ans = Math.max(ans, i);
		}

		return ans;
	}

}
