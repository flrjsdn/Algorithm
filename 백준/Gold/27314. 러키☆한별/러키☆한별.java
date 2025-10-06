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
    static int hX, hY;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int bfs(int x,int y) {
        visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y,0});
        visited[x][y] = true;
        int cnt = 0;
        int hCnt = (int) 1e9;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(map[now[0]][now[1]] == 'H') {
                hCnt = now[2];
                continue;
            } else if(map[now[0]][now[1]] == 'P' && now[2] <= hCnt) cnt++;

            if(now[2] > hCnt) break;
            
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx,ny,now[2] + 1});
                }
            }
        }
        if(hCnt == (int)1e9) cnt = -1;
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        List<int[]> exit = new ArrayList<>();
        
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == '#') exit.add(new int[] {i,j});
                else if(map[i][j] == 'H') {
                    hX = i;
                    hY = j;
                }
            }
        }

        int ans = 0;
        for(int[] next : exit) {
            ans = Math.max(ans, bfs(next[0], next[1]));
        }
        System.out.println(ans);
    }
}