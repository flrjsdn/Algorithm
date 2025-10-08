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

    static int H,W;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static boolean[][] visited;

    static boolean bfs(int x,int y,int num) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] color = new boolean[H][W];
        visited[x][y] = true;
        color[x][y] = true;
        q.add(new int[] {x,y});
        int cnt = 1;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
                if(!visited[nx][ny] && map[nx][ny] == num) {
                    visited[nx][ny] = true;
                    color[nx][ny] = true;
                    q.add(new int[] {nx,ny});
                    cnt++;
                }
            }
        }

        if(cnt >= 4) {
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    if(color[i][j]) map[i][j] = 0;
                }
            }
            return true;
        }
        return false;
    }

    static void falling() {
    for(int j=0; j<W; j++) {
        int lastIdx = H - 1; 

        for(int i=H-1; i>=0; i--) {
            if(map[i][j] != 0) {
                if(i == lastIdx) {
                    lastIdx--; 
                    continue;
                }
                
                map[lastIdx][j] = map[i][j];
                
                map[i][j] = 0;
                
                lastIdx--; 
            }
        }
    }
}

    static void print() {
        for(int i=0;i<H;i++) {
            for(int j=0;j<W;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        H = 12; W = 6;
        map = new int[H][W];
        for(int i=0;i<H;i++) {
            String s = br.readLine();
            for(int j=0;j<W;j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '.':
                        map[i][j] = 0;
                        break;
                    case 'R':
                        map[i][j] = 1;
                        break;
                    case 'Y':
                        map[i][j] = 2;
                        break;
                    case 'G':
                        map[i][j] = 3;
                        break;
                    case 'B':
                        map[i][j] = 4;
                        break;
                    case 'P':
                        map[i][j] = 5;
                        break;
                }
            }
        }

        boolean check = false;
        int ans = 0;
        while(true) {
            check = false;
            visited = new boolean[H][W];
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {
                        if(bfs(i,j, map[i][j])) check = true;
                    }
                }
            }
            falling();

            if(!check) break;
            else ans++;
        }
        System.out.println(ans);
    }
}