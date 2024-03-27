import java.io.*;
import java.util.*;

class Position {
    private int x;
    private int y;
    private int distance;

    public Position(int x,int y,int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }
}
public class Main {

    public static int n,m;
    public static int[][] map = new int[101][101];
    public static boolean[][] visited = new boolean[101][101];
    public static int[][] result = new int[101][101];

    public static ArrayList<Position> arr = new ArrayList<>();

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void bfs(int x, int y, int distance) {
        visited[x][y] = true;
        Queue<Position> q = new LinkedList<>();

        q.offer(new Position(x,y, distance));

        while(!q.isEmpty()) {
            Position pos = q.poll();
            int posX = pos.getX();
            int posY = pos.getY();
            int posDistance = pos.getDistance();

            for(int i=0;i<4;i++) {
                int nx = posX + dx[i];
                int ny = posY + dy[i];

                if(nx > 0 && nx <= n && ny > 0 && ny <= m &&!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    result[nx][ny] = posDistance + 1;
                    q.offer(new Position(nx,ny, result[nx][ny]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<n;i++) {
            String str = sc.next();
            for(int j=0;j<m;j++) {
                map[i+1][j+1] = str.charAt(j) - '0';
            }
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                bfs(i,j,1);
            }
        }

        System.out.println(result[n][m]);
    }
}