import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int h,w;
    static int[][] map;
    static int[] dy = {1,-1, 0, 0};
    static int[] dx = {0,0,1,-1};
    static boolean[][] visited;
    static int answer = 0;

    static void bfs(int x,int y) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        if(map[x][y] == 1) return;
        q.add(new int[] {x,y, 1});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();

            int ny = now[1] + dy[0];
            if(ny >= w) continue;
            if(map[x][ny] == 1) {
                answer += now[2];
                return;
            }
            if(!visited[x][ny] && map[x][ny] == 0) {
                visited[x][ny] = true;
                q.add(new int[] {x,ny, now[2] + 1});
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++) {
            int water = Integer.parseInt(st.nextToken());
            for(int j=h-water;j<h;j++) {
                map[j][i] = 1;
            }
        }

        for(int i=0;i<h;i++) {
            for(int j=0;j<w-1;j++) {
                if(map[i][j] == 1 && !visited[i][j+1]) {
                    bfs(i,j+1);
                }
            }
        }
        System.out.println(answer);
    }
}