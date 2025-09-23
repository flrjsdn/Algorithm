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
    static int ans;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] visited;

    static int dfs(int x,int y) {
        if(visited[x][y] != 0) {
            return visited[x][y];
        }

        int max = 0;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(map[x][y] < map[nx][ny]) {
                max = Math.max(max, dfs(nx,ny));
            }
        }
        visited[x][y] = 1 + max;
        return visited[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        N = read();
        map = new int[N][N];
        visited = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = read();
            }
        }

        ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                ans = Math.max(ans, dfs(i,j));
            }
        }
        System.out.println(ans);
    }
}