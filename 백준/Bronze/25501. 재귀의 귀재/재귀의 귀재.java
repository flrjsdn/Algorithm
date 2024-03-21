import java.io.*;
import java.util.*;
public class Main {
    public static int count = 0;
    public static int recursion(String s, int l, int r) {
        count++;
        if(l>=r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=0;tc < T;tc++) {
            String s = sc.next();
            int resultP = isPalindrome(s);
            System.out.println(resultP + " " + count);
            count = 0;
        }

    }
}