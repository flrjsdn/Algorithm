import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[][] map;
    static int N, ans;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;

    static void backtracking(int index, int cnt) {

        if(cnt == 7) {
            out:for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(visited[i][j]) {
                        if(bfs(i,j)) {
                            ans++;
                            break out;
                        }
                    }
                }
            }
            return;
        }
        
        for(int i=index;i<N*N;i++) {
            int row = i / 5;
            int col = i % 5;
            if(!visited[row][col]) {
                visited[row][col] = true;
                backtracking(i+1, cnt+1);
                visited[row][col] = false;
            }
        }
    }

    static boolean bfs(int x,int y) {
        boolean[][] v = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        v[x][y] = true;
        
        int cntS = 0;
        int c = 0;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            c++;
            if(map[now[0]][now[1]] == 'S') cntS++;
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(visited[nx][ny] && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                }
            }
        }

        return (c ==7) && (cntS >= 4);
    }
    public static void main(String[] args) throws IOException {
        N = 5;
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = s.charAt(j);
            }
        }

        ans = 0;
        backtracking(0,0);
        System.out.println(ans);
    }
}