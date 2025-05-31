import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] dp;
    static int n;
    static final int MOD = 10_007;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][10];
        Arrays.fill(dp[1], 1);

        for(int i=2;i<=n;i++) {
            dp[i][0] = 1;
            dp[i][1] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            for(int j=2;j<=9;j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD; 
            }
        }

        int sum = 0;
        for(int i=0;i<=9;i++) {
            sum = (sum + dp[n][i]) % MOD;
        }
        System.out.println(sum);
    }
}