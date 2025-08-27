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

    static int N,M,T;
    static final int INF = (int) 1e9;
    static int[][] dist;
    
    public static void main(String[] args) throws Exception {
        N = read(); M = read(); T = read();
        dist = new int[N+1][N+1];

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i==j) continue;
                dist[i][j] = INF;
            }
        }

        for(int i=0;i<M;i++) {
            int a = read();
            int b = read();
            int c = read();
            dist[a][b] = Math.min(dist[a][b],c);
        }

        for(int k=1;k<=N;k++) {
            for(int i=1;i<=N;i++) {
                for(int j=1;j<=N;j++) {
                    int max = Math.max(dist[i][k], dist[k][j]);
                    dist[i][j] = Math.min(dist[i][j], max);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {
            int s = read();
            int e = read();
            if(dist[s][e] == INF) sb.append("-1\n");
            else sb.append(dist[s][e] + "\n");
        }
        System.out.println(sb);
    }
}