import java.util.Scanner;
/** SW Expert 1984. 중간 평균값 구하기 **/
public class Solution8 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int max=-1;
			int min=10000;
			double sum=0.0;
			for(int i=0;i<10;i++) {
				int num=sc.nextInt();
				sum+=num;
				if(max<num) {
					max=num;
				}
				if(min>num) {
					min=num;
				}
			}
			sum=sum-min-max;
			double avg=Math.round(sum/8);
			System.out.println("#"+test_case+" "+(int)avg);
			

		}

	}

}
