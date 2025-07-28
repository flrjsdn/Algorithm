import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int w,h;
    static int sX,sY, ans;
    static boolean check;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] map;
    static int[][] fire;
    static boolean[][] visited;
    static final int INF = (int) 1e9;

    static Queue<int[]> fireQ;

    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.add(new int[] {x,y,0});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                //도착 시, return
                if(nx<0 || nx>=h || ny<0 || ny>=w) {
                    check = true;
                    ans = now[2] + 1;
                    return;
                }
                if(!visited[nx][ny] && map[nx][ny] == '.' && now[2] + 1 < fire[nx][ny]) {
                    q.add(new int[] {nx,ny, now[2]+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void init() {
        while(!fireQ.isEmpty()) {
            int[] now = fireQ.poll();

            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=h || ny<0 || ny>=w) continue;
                if(!visited[nx][ny] && map[nx][ny] != '#') {
                    fireQ.add(new int[] {nx,ny});
                    fire[nx][ny] = fire[now[0]][now[1]] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static void printMap() {
        for(int i=0;i<h;i++) {
            for(int j=0;j<w;j++) {
                System.out.print(fire[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            fire = new int[h][w];
            visited = new boolean[h][w];
            fireQ = new ArrayDeque<>();

            for(int i=0;i<h;i++) {
                Arrays.fill(fire[i], INF);
            }
            for(int i=0;i<h;i++) {
                String s = br.readLine();
                for(int j=0;j<w;j++) {
                    map[i][j] = s.charAt(j);
                    if(map[i][j] == '@') {
                        sX = i;
                        sY = j;
                        map[i][j] = '.';
                    } else if(map[i][j] == '*') {
                        fire[i][j] = 0;
                        fireQ.add(new int[] {i,j});
                        visited[i][j] = true;
                    }
                }
            }

            check = false;
            ans = 0;
            init();
            visited = new boolean[h][w];
            bfs(sX,sY);
            if(check) sb.append(ans + "\n");
            else sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
}