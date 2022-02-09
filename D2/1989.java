import java.util.*;

/** SW Expert 1989. 초심자의 회문 검사 **/
public class Solution6 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			// 글자수가 짝수일때
			if (str.length() % 2 == 0) {
				String reversed=new StringBuffer(str.substring(str.length()/2)).reverse().toString();
				if(str.substring(0,str.length()/2).equals(reversed)) {
					System.out.println("#"+test_case+" 1");
				}else {
					System.out.println("#"+test_case+" 0");
				}
			}
			// 글자수가 홀수일때
			else {
				String reversed=new StringBuffer(str.substring(str.length()/2+1)).reverse().toString();
				if(str.substring(0,str.length()/2).equals(reversed)) {
					System.out.println("#"+test_case+" 1");
				}else {
					System.out.println("#"+test_case+" 0");
				}
			}
			
		}

	}

}
