import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int MOD = 100_0000;
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0') dp[1] = 0;
        else dp[1] = 1;
        for(int i=2;i<=s.length();i++) {
            int first = s.charAt(i-2) - '0';
            int second = s.charAt(i-1) - '0';
            int num = first * 10 + second;
            if(second == 0) {
                if(first < 1 || first > 2) {
                    System.out.println(0);
                    return;
                }
            }
            if(second == 0) dp[i] = dp[i-2];
            else if(num <= 26 && num >= 10) dp[i] = (dp[i-1] + dp[i-2]) % MOD;
            else dp[i] = dp[i-1];
        }
        System.out.println(dp[s.length()] % MOD);
    }
}