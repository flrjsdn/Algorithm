import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static int[][] map;
    static HashSet<Integer>[] set;
    static int[] dx = {0,1, -1, 0};
    static int[] dy = {1,0, 0, -1};
    static int favorite, emptySpace;
    
    static void bfs(int num, int x,int y) {
        boolean[][] visited = new boolean[n][n];
        int findX = x, findY = y;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        favorite = findF(num, x,y);
        emptySpace = findE(num,x,y);
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowF = findF(num, now[0], now[1]);
            int nowE = findE(num, now[0], now[1]);
            if(map[now[0]][now[1]]== 0 && nowF > favorite) {
                findX = now[0];
                findY = now[1];
                favorite = nowF;
                emptySpace = nowE;
            } else if(map[now[0]][now[1]]== 0 && nowF == favorite) {
                if(nowE > emptySpace || (nowE == emptySpace &&
                                        (now[0] < findX || (now[0] == findX &&
                                                           now[1] < findY)))) {
                    findX = now[0];
                    findY = now[1];
                    favorite = nowF;
                    emptySpace = nowE;
                }
            }
            
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                if(!visited[nx][ny]) {
                    q.add(new int[] {nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }

        if(map[findX][findY] == 0) map[findX][findY] = num;
    }

    static int findF(int num, int x,int y) {
        int cnt = 0;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(set[num].contains(map[nx][ny])) cnt++;
        }
        return cnt;
    }

    static int findE(int num, int x, int y) {
        int cnt = 0;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(map[nx][ny]==0) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        set = new HashSet[((int) Math.pow(n,2)) + 1];
        for(int i=0;i<=(int) Math.pow(n,2);i++) {
            set[i] = new HashSet<>();
        }
        
        StringTokenizer st;
        for(int i=0;i<(int) Math.pow(n,2);i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<4;j++) {
                set[num].add(Integer.parseInt(st.nextToken()));
            }

            S:for(int j=0;j<n;j++) {
                for(int k=0;k<n;k++) {
                    if(map[j][k] == 0) {
                        bfs(num, j, k);
                        break S;
                    }
                }
            }

        }
        int sum = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                int count = findF(map[i][j], i, j);
                if(count == 0) continue;
                sum += (int) Math.pow(10, count-1);
            }
        }
        System.out.println(sum);
    }
}