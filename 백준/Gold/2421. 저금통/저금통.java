import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws IOException {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int N;
    static boolean[] visited;
    static int[][] dp;
    static boolean sosu(int num) {
        for(int i=2;i<=(int) Math.sqrt(num);i++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    static void findS() {
        for(int i=2;i<=999999;i++) {
            if(visited[i]) continue;
            if(sosu(i)) {
                for(int j=i*2;j<=999999;j+=i) visited[j] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        N = read();
        dp = new int[N+1][N+1];
        visited = new boolean[1_000_000];
        findS();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i==1 && j==1) continue;
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                int sum = Integer.parseInt(String.valueOf(i) + String.valueOf(j));
                if(!visited[sum]) dp[i][j] += 1;
            }
        }
        
        System.out.println(dp[N][N]);
    }
}