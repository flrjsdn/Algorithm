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

    static int[][] map;
    static int N = 9;
    static boolean check;
    static StringBuilder sb;

    static void dfs(int x, int y) {
        if(check) return;
        if(y == N) {
            dfs(x+1, 0);
            return;
        }

        if(x == N) {
            sb = new StringBuilder();
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            check = true;
            return;
        }

        if(map[x][y] == 0) {
            for(int i=1;i<=N;i++) {
                if(possible(x,y,i)) {
                    map[x][y] = i;
                    dfs(x, y+1);
                }
            }
            map[x][y] = 0;
            return;
        }
        dfs(x,y+1);
    }

    static boolean possible(int x,int y,int num) {

        for(int i=0;i<N;i++) {
            if(map[x][i] == num) return false;
        }

        for(int i=0;i<N;i++) {
            if(map[i][y] == num) return false;
        }

        int row = (x/3) * 3;
        int col = (y/3) * 3;

        for(int i=row;i<row+3;i++) {
            for(int j=col;j<col+3;j++) {
                if(map[i][j] == num) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) throws Exception {
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = read();
            }
        }

        dfs(0,0);
        System.out.println(sb.toString());
    }
}