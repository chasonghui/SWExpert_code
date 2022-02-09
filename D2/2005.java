import java.util.Arrays;
import java.util.Scanner;
/** SW Expert 2005. 파스칼의 삼각형 **/
public class Solution4 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int[][] pascal=new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<=i;j++) {
					if(i==j) {//맨 오른쪽
						pascal[i][j]=1;
					}
					else if(j==0) {//맨 왼쪽
						pascal[i][j]=1;
					}
					else {//중간
						pascal[i][j]=pascal[i-1][j]+pascal[i-1][j-1];
					}
				}

				
			}
			System.out.println("#"+test_case);
			for(int k=0;k<N;k++) {
				for(int l=0;l<=k;l++) {
					System.out.print(pascal[k][l]+" ");
				}
				System.out.println();
			}
		}

	}

}
