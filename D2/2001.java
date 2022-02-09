import java.util.*;
/** SW Expert 2001. 파리 퇴치 **/
public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];//맵 생성
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] = sc.nextInt();
                }
            }
            int max = 0;
            //파리채 위치 옮기기
            for (int l = 0; l < N - M + 1; l++) {
                for (int m = 0; m < N - M + 1; m++) {
                    int sum = 0;
                    //파리채 영역 더하기
                    for (int n = 0; n < M; n++) {
                        for (int o = 0; o < M; o++) {
                            sum += map[l + n][m + o];
                        }
                    }
                    //최댓값 구하기
                    if (max < sum)
                        max = sum;
                }
            }
            System.out.println("#" + i + " " + max);
        }
    }
}
