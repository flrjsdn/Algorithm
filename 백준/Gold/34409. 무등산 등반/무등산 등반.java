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

    static int N,M;
    static int A,B,C;
    static int dX, dY;
    static final int INF = (int) 1e9;
    static int[][] dist;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans;
    static int[][] map;

    static void dijk(int x,int y) {
        dist = new int[N+1][M+1];
        for(int i=0;i<=N;i++) {
            Arrays.fill(dist[i], INF);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
        q.add(new int[] {x,y,0});
        dist[x][y] = 0;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == dX && now[1] == dY) {
                ans = Math.min(ans, now[2]);
                return;
            }

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<=0 || nx>N || ny<=0 || ny>M) continue;
                int h = map[now[0]][now[1]] - map[nx][ny];
                if(Math.abs(h) <= C) {
                    int cost = 1;
                    if(h<0) cost = Math.abs(h) * A;
                    else if(h>0) cost = h * B;
                    if(now[2] + cost < dist[nx][ny]) {
                        dist[nx][ny] = now[2] + cost;
                        q.add(new int[] {nx,ny,dist[nx][ny]});
                    }
                }
            }
        }
        
    }
    public static void main(String[] args) throws IOException {
        N = read(); M = read();
        int x = read();
        int y = read();
        A = read(); B = read(); C = read();
        map = new int[N+1][M+1];

        int max = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                map[i][j] = read();
                if(map[i][j] > max) {
                    max = map[i][j];
                    dX = i;
                    dY = j;
                }
            }
        }

        ans = INF;
        dijk(x,y);
        System.out.println(ans == INF ? -1 : ans);
    }
}