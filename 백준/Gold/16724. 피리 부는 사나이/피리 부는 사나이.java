import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static char[][] map;
    static int n,m, ans;
    static int[][] visited;

    static void dfs(int x,int y, int station) {
        visited[x][y] = station;

        int d = direction(map[x][y]);
        int nx = x + dx[d];
        int ny = y + dy[d];
        if(visited[nx][ny] == 0) dfs(nx,ny, station);
        else if(visited[nx][ny] != station) return;
        else if(visited[nx][ny] == station) {
            ans++;
            return;
        }
    }

    static int direction(char c) {
        switch(c) {
            case 'L' :
                return 3;
            case 'R' :
                return 2;
            case 'U' :
                return 1;
            case 'D' :
                return 0;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new int[n][m];
        for(int i=0;i<n;i++) {
            String s = br.readLine();
            for(int j=0;j<m;j++) {
                map[i][j] = s.charAt(j);
            }
        }

        ans = 0;
        int station = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j] == 0) {
                    dfs(i,j, station++);
                }
            }
        }
        System.out.println(ans);
    }
}