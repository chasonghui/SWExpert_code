package Algo_SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//3499 D3 퍼펙트 셔플
public class D3퍼펙트셔플 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();// 카드 갯수

			String[] card = new String[N];
			String[] Ans = new String[N];

			int first = 0;
			int mid = 0;
			boolean upanddown = true;

			// 카드 짝수개
			if (N % 2 == 0) {
				mid = N / 2;
			} else {// 카드 홀수개
				mid = N / 2 + 1;
			}

			// 카드 저장
			for (int j = 0; j < N; j++) {
				card[j] = sc.next();
			}

			// 카드가 번갈아 들어갈 수 있게
			for (int j = 0; j < N; j++) {
				if (upanddown) {
					Ans[j] = card[first];
					first++;
					upanddown = false;
				} else {
					Ans[j] = card[mid];
					mid++;
					upanddown = true;
				}
			}

			System.out.print("#" + i + " ");
			for (int j = 0; j < N; j++) {
				System.out.print(Ans[j] + " ");
			}
			System.out.println();

		}
	}

}
