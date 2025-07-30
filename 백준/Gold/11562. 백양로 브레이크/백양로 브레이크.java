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

    static final int INF = (int) 1e9;
    static int n,m,k;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        dist = new int[n+1][n+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dist[i], INF);
        }
        for(int i=0;i<=n;i++) {
            dist[i][i] = 0;
        }
        for(int i=0;i<m;i++) {
            int a = read();
            int b = read();
            int c = read();
            if(c == 0) {
                dist[a][b] = 0;
                dist[b][a] = 1;
            }
            else {
                dist[a][b] = 0;
                dist[b][a] = 0;
            }
        }

        for(int q=1;q<=n;q++) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=n;j++) {
                    if(i==j || i==q || j==q) continue;
                    if(dist[i][j] > dist[i][q] + dist[q][j]) {
                        dist[i][j] = dist[i][q] + dist[q][j];
                    }
                }
            }
        }

        k = read();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++) {
            int a = read();
            int b = read();
            sb.append(dist[a][b] + "\n");
        }
        System.out.println(sb);
    }
}