import java.io.*;
import java.util.*;

class Position {
    private int x;
    private int y;

    public Position(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
public class Main {

    public static int n,m;
    public static int[][] map = new int[1000][1000];
    public static Queue<Position> q = new LinkedList<>();

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static void bfs() {
        while(!q.isEmpty()) {
            Position pos = q.poll();
            int posX = pos.getX();
            int posY = pos.getY();

            for(int i=0;i<4;i++) {
                int nx = posX + dx[i];
                int ny = posY + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
                    map[nx][ny] = map[posX][posY] + 1;
                    q.offer(new Position(nx,ny));
                }
            }
        }
        int max = -1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(max < map[i][j]){
                    max = map[i][j];
                }
            }
        }
        if(check()) System.out.println(max-1);
        else System.out.println(-1);
    }

    public static boolean check() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    q.offer(new Position(i,j));
                }
            }
        }
        bfs();
    }
}