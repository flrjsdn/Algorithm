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

    static final int INF = Integer.MAX_VALUE;
    static int n,T, ans;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][][] dist;

    static void dijk(int x,int y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[3]-o2[3]);
        pq.add(new int[] {x,y,0,0});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(dist[now[0]][now[1]][now[2]] < now[3]) continue;

            if(now[0] == n-1 && now[1] == n-1) {
                System.out.println(now[3]);
                return;
            }
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                int ns = (now[2] + 1) % 3;                // 다음 step
                int nc = now[3] + T + (now[2] == 2 ? map[nx][ny] : 0);
                
                if(dist[nx][ny][ns] > nc) {
                    dist[nx][ny][ns] = nc;
                    pq.add(new int[] {nx,ny,ns,nc});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        n = read(); T = read();
        map = new int[n][n];
        dist = new int[n][n][3];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int s=0;s<3;s++) {
                    dist[i][j][s] = INF;
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = read();
            }
        }

        dist[0][0][0] = 0;
        dijk(0,0);
    }
}