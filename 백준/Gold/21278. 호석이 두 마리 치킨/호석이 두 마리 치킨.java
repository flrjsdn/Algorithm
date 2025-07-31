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

    static int n,m;
    static final int INF = (int) 1e9;
    static int[][] dist;
    
    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        dist = new int[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(i==j) continue;
                dist[i][j] = INF;
            }
        }
        for(int i=0;i<m;i++) {
            int a = read();
            int b = read();
            dist[a][b] = 2;
            dist[b][a] = 2;
        }

        for(int k=1;k<=n;k++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(i==j) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int x = 0, y = 0;
        int sum = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++) {
            int cal = 0;
            for(int j=i+1;j<=n;j++) {
                for(int k=1;k<=n;k++) {
                    cal += Math.min(dist[i][k], dist[j][k]);
                }
                if(cal < sum) {
                    x = i;
                    y = j;
                    sum = cal;
                }
            }
        }
        System.out.println(x + " " + y + " " + sum);
    }
}