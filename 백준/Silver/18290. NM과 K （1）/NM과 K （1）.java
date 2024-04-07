import java.io.*;
import java.util.*;
public class Main {
    public static int n,m,k, result = Integer.MIN_VALUE;
    public static int[][] map = new int[11][11];
    public static boolean[][] visited = new boolean[11][11];

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == k) {
            result = Math.max(result, sum);
            return;
        }

        for(int i = x;i < n;i++) {
            for(int j = y;j < m;j++) {
                if(!visited[i][j]) {
                    if(check(i,j)) {
                        visited[i][j] = true;
                        dfs(x,y,depth+1, sum + map[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        boolean flag = true;
        for(int i=0;i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if(visited[nx][ny]) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,0,0,0);
        System.out.println(result);
    }
}