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

    static int N,M,G,R;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans;

    static void back(int depth, int idx, int red, int green, List<int[]> arr) {
        if(depth == (G+R)) {
            ans = Math.max(ans, check(arr));
            return;
        }

        for(int i=idx;i<(N*M);i++) {
            int x = i/M;
            int y = i%M;
            if(map[x][y] == 2) {
                if(red > 0) {
                    arr.add(new int[] {x,y,0});
                    back(depth+1, i+1, red-1, green, arr);
                    arr.remove(arr.size()-1);
                }
                if(green > 0) {
                    arr.add(new int[] {x,y,1});
                    back(depth+1, i+1, red, green-1, arr);
                    arr.remove(arr.size()-1);
                }
            }
        }
    }

    static int check(List<int[]> arr) {
        int[][][] visited = new int[2][N][M];
        for(int i=0;i<2;i++) {
            for(int j=0;j<N;j++) {
                for(int k=0;k<M;k++) {
                    visited[i][j][k] = -1;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] next : arr) {
            visited[0][next[0]][next[1]] = next[2];
            visited[1][next[0]][next[1]] = 0;
            q.add(new int[] {next[0], next[1], 0, next[2]});
        }

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(visited[0][now[0]][now[1]] == 3) continue;
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=N || ny<0 || ny>=M || map[nx][ny] == 0) continue;
                if(visited[0][nx][ny] == -1) {
                    visited[0][nx][ny] = now[3];
                    visited[1][nx][ny] = now[2] + 1;
                    q.add(new int[] {nx,ny,now[2]+1, now[3]});
                } else if((visited[0][nx][ny] ^ now[3]) == 1 && visited[1][nx][ny] == (now[2]+1)) {
                    visited[0][nx][ny] = 3;
                    visited[1][nx][ny] = -1;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        N = read(); M = read(); G = read(); R = read();

        map = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                map[i][j] = read();
            }
        }

        ans = 0;
        back(0,0,R,G,new ArrayList<>());
        System.out.println(ans);
    }
}