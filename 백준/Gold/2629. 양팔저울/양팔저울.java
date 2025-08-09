import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int N, G;
    static final int INF = 40_000;
    static int[] weights;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception {
        N = read();
        weights = new int[N+1];
        dp = new boolean[N+1][INF+1];
        for(int i=1;i<=N;i++) {
            weights[i] = read();
        }

        for(int i=1;i<=N;i++) {
            int now = weights[i];
            dp[i][now] = true;
            for(int j=1;j<=INF;j++) {
                if(dp[i-1][j]) {
                    dp[i][j] = true;
                    if(Math.abs(j-now) > 0 && Math.abs(j-now) <= INF) dp[i][Math.abs(j-now)] = true;
                    if(j+now <= INF) dp[i][j+now] = true;
                }
            }
        }

        G = read();
        StringBuilder sb = new StringBuilder();
        // for(int i=1;i<=10;i++) {
        //     System.out.print(dp[N][i] + " ");
        // }
        for(int i=0;i<G;i++) {
            int g = read();
            if(dp[N][g]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb.toString());
    }
}