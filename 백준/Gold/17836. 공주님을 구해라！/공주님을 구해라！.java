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

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][][] visited;
    static int N,M,T,ans;
    static int[][] map;
    //벽으로는 통과 불가능, 하지만 그람이 있으면 이동 가능
    //그람을 줍고 가는 경우, 그람을 줍지 않고 가는 경우 2가지
    //현재 상태를 x,y,걸린소요시간,그람소유여부로 저장

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][1][1] = true;
        q.add(new int[] {1,1,0,0});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == N && now[1] == M) {
                ans = Math.min(ans, now[2]);
                return;
            }
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<=0 || nx>N || ny<=0 || ny>M) continue;
                if(now[3] == 1) { //검을 소유한 경우
                    if(!visited[now[3]][nx][ny]) {
                        visited[now[3]][nx][ny] = true;
                        q.add(new int[] {nx,ny,now[2]+1,now[3]});
                    }
                } else { //소지하지 않은 경우
                    if(!visited[now[3]][nx][ny] && map[nx][ny] != 1) {
                        visited[now[3]][nx][ny] = true;
                        if(map[nx][ny] == 2) q.add(new int[] {nx,ny,now[2]+1, 1});
                        else q.add(new int[] {nx,ny,now[2]+1, now[3]});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        N = read(); M = read(); T = read();
        map = new int[N+1][M+1];
        //그람 소유 이동, 그람 소유하지 않은 이동
        visited = new boolean[2][N+1][M+1];
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                map[i][j] = read();
            }
        }

        ans = Integer.MAX_VALUE;
        bfs();
        if(ans == Integer.MAX_VALUE || ans > T) System.out.println("Fail");
        else System.out.println(ans);
    }
}