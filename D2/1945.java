import java.util.Scanner;
/** SW Expert 1945. 간단한 소인수분해 **/
public class Solution11 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++) {
            int n = sc.nextInt();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;
            while( n%2 == 0 ) { n /= 2; a++; }
            while( n%3 == 0 ) { n /= 3; b++; }
            while( n%5 == 0 ) { n /= 5; c++; }
            while( n%7 == 0 ) { n /= 7; d++; }
            while( n%11 == 0 ) { n /= 11; e++; }
            System.out.println("#"+test_case+" "+a+" "+b+" "+c+" "+d+" "+e);
        }
    }
}
