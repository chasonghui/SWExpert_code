import java.util.Scanner;
 //D3 상호의 배틀필드
public class SWEA_1873 {
    static int[][] dir = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
 
            char[][] map = new char[H][W];
 
            int x = 0;
            int y = 0;
            int d = 0;
 
            for (int i = 0; i < H; i++) {
                String st = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = st.charAt(j);
 
                    if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
                        if (map[i][j] == '^')
                            d = 1;
                        else if (map[i][j] == 'v')
                            d = 2;
                        else if (map[i][j] == '<')
                            d = 3;
                        else if (map[i][j] == '>')
                            d = 4;
 
                        x = i;
                        y = j;
                    }
                }
            }
 
            int N = sc.nextInt();
 
            String str = sc.next();
 
            for (int i = 0; i < N; i++) {
                char cmd = str.charAt(i);
                int nx, ny;
 
                if (cmd == 'U' || cmd == 'D' || cmd == 'L' || cmd == 'R') {
                    if (cmd == 'U') {
                        d = 1;
                        map[x][y] = '^';
                    } else if (cmd == 'D') {
                        d = 2;
                        map[x][y] = 'v';
                    } else if (cmd == 'L') {
                        d = 3;
                        map[x][y] = '<';
                    } else if (cmd == 'R') {
                        d = 4;
                        map[x][y] = '>';
                    }
 
                    nx = x + dir[d][0];
                    ny = y + dir[d][1];
 
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (map[nx][ny] == '.') {
                            map[nx][ny] = map[x][y];
                            map[x][y] = '.';
                            x = nx;
                            y = ny;
                        }
                    }
                } else if (cmd == 'S') {
                    // 바라보는 방향으로 포탄 발사
                    nx = x;
                    ny = y;
 
                    while (true) {
                        nx += dir[d][0];
                        ny += dir[d][1];
                        if (nx < 0 || nx >= H || ny < 0 || ny >= W || map[nx][ny] == '#')
                            break;
                        else if (map[nx][ny] == '*') {
                            map[nx][ny] = '.';
                            break;
                        }
                    }
                }
            }
 
            System.out.print("#" + tc + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
 
}