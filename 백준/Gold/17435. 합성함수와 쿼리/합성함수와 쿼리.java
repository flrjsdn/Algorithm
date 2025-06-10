import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int h = (int) Math.ceil(Math.log(200000)/Math.log(2)) + 1;
        int[][] dp = new int[m+1][h];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=m;i++) {
            int n = Integer.parseInt(st.nextToken());
            dp[i][0] = n;
        }

        for(int j=1;j<h;j++) {
            for(int i=1;i<=m;i++) {
                dp[i][j] = dp[dp[i][j-1]][j-1];
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for(int j=h-1;j>=0;j--) {
                if(n >= (1<<j)) {
                    n -= (1<<j);
                    x = dp[x][j];
                }
            }
            sb.append(x + "\n");
        }
        System.out.println(sb);
    }
}