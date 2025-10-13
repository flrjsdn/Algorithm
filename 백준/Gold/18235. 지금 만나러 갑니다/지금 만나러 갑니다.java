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

    static int N,A,B;
    static int[][] visited;

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {A, 1, 0, 0});
        q.add(new int[] {B, 1, 1, 0});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(visited[now[2]^1][now[0]] == now[3]) {
                return now[3];
            }
            int np = now[0] + now[1];
            int nm = now[0] - now[1];
            if(np>0 && np<=N) {
                visited[now[2]][np] = now[3]+1;
                q.add(new int[] {np,now[1]*2, now[2], now[3] + 1});
            }

            if(nm>0 && nm<=N) {
                visited[now[2]][nm] = now[3]+1;
                q.add(new int[] {nm,now[1]*2, now[2], now[3] + 1});
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        N = read(); A = read(); B = read();
        visited = new int[2][N+1];
        for(int i=0;i<2;i++) {
            Arrays.fill(visited[i], -1);
        }
        System.out.println(bfs());
    }
}