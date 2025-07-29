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

    static int n,k,r;
    static int ans;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    // a->b로 길을 안거치고 가는 경우
    static boolean[][] visited;
    static boolean[][][][] road;
    static boolean[][] check;
    static int[][] map;
    static ArrayList<int[]> arr;

    static void bfs(int x, int y, int num) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x,y});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();

            int cow = map[now[0]][now[1]];
            if(cow != 0 && cow != num) {
                if(!check[num][cow]) {
                    ans += 1;
                    check[num][cow] = true;
                    check[cow][num] = true;
                }
            }
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<=0 || nx>n || ny<=0 || ny>n) continue;
                if(!visited[nx][ny] && !road[now[0]][now[1]][nx][ny]) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        n = read(); k = read(); r = read();
        road = new boolean[n+1][n+1][n+1][n+1];
        map = new int[n+1][n+1];
        check = new boolean[k+1][k+1];
        arr = new ArrayList<>();


        for(int i=0;i<r;i++) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();
            road[x1][y1][x2][y2] = true;
            road[x2][y2][x1][y1] = true;
        }

        for(int i=1;i<=k;i++) {
            int x = read();
            int y = read();
            map[x][y] = i;
            arr.add(new int[] {x,y, i});
        }

        ans = 0;
        for(int[] next : arr) {
            visited = new boolean[n+1][n+1];
            bfs(next[0], next[1], next[2]);
        }
        System.out.println((k*(k-1) / 2) - ans);
    }
}