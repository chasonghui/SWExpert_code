import java.util.Scanner;
/** SW Expert 1976. 시각 덧셈 **/
public class Solution12 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();
            int h = h1 + h2;
            int m = m1 + m2;
            if( m > 60 ) {
                m -= 60;
                h++;
            }
            if( h > 12 ) h -= 12;
            System.out.println("#"+test_case+" "+h+" "+m);
        }

	}

}
