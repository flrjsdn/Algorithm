import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans;

    static void bfs(int x,int y) {
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x,y,0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            ans = Math.max(ans, now[2]);

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny,now[2]+1});
                }
            }
            
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = s.charAt(j);
            }
        }

        ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 'L') bfs(i,j);
            }
        }
        System.out.println(ans);
    }
}