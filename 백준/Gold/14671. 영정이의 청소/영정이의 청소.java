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
    
    static int N,M,K;
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception {
        N = read(); M = read(); K = read();
        visited = new boolean[2][2];
        for(int i=0;i<K;i++) {
            int x = read();
            int y = read();
            visited[x % 2][y % 2] = true;
        }

        if(visited[0][0] && visited[0][1] && visited[1][0] && visited[1][1])
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}