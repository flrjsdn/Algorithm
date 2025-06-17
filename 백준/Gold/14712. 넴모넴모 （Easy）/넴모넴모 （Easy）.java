import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,m, ans;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;


    static void dfs(int start, int depth) {
        ans += check(depth) ? 1 : 0;
        if(depth == n*m) {
            return;
        }

        for(int i=start;i<n*m;i++) {
            int x = i/m;
            int y = i%m;
            if(visited[x][y]) continue;
            visited[x][y] = true;
            dfs(i+1, depth+1);
            visited[x][y] = false;
        }
    }

    static boolean check(int depth) {
        if(depth < 4) return true;

        for(int i=0;i<n-1;i++) {
            for(int j=0;j<m-1;j++) {
                if(visited[i][j] && visited[i][j+1] && visited[i+1][j] && visited[i+1][j+1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        ans = 0;
        dfs(0, 0);
        System.out.println(ans);
    }
}