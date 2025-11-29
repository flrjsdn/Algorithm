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

    static int N, K, ans;
    static int[][] dis;
    static boolean[] visited;

    static void dfs(int depth, int prev, int sum) {
        if(depth == N) {
            ans = Math.min(ans, sum);
            return;
        }

        for(int i=0;i<N;i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(depth+1, i, sum + dis[prev][i]);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        N = read(); K = read();
        dis = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                dis[i][j] = read();
            }
        }

        for(int k=0;k<N;k++) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(i==j) continue;
                    if(dis[i][k] + dis[k][j] < dis[i][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        visited = new boolean[N];
        ans = Integer.MAX_VALUE;
        dfs(0,K,0);
        System.out.println(ans);
    }
}