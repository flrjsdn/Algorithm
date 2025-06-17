import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n,m, ans;
    static boolean[][] visited;


    static void dfs(int x,int y) {
        if(check(x,y)) return;

        if(x==n-1 && y==m-1) {
            ans++;
            return;
        }
        int nx = x;
        int ny = y;
        if(ny==m-1) {
            nx +=1;
            ny=0;
        } else{
            ny+=1;
        }

        visited[nx][ny] = true;
        dfs(nx,ny);

        visited[nx][ny] = false;
        dfs(nx,ny);
    }

    static boolean check(int x,int y) {
        return (x>=1 && y>=1 && visited[x][y] && visited[x-1][y] && visited[x][y-1] && visited[x-1][y-1]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];

        ans = 0;
        visited[0][0] = true;
        dfs(0,0);

        visited[0][0] = false;
        dfs(0,0);
        System.out.println(ans);
    }
}