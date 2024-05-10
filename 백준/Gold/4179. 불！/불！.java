import java.util.*;
import java.io.*;

public class Main {
	public static int r,c;
	public static char[][] map;
	
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int[][] visited;
	public static int[][] fire;
	public static boolean check = false;
	public static Queue<int[]> qFire = new LinkedList<>();
	public static Queue<int[]> qJ = new LinkedList<>();
	
	public static void firebfs() {
		while(!qFire.isEmpty()) {
			int[] now = qFire.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0;i<4;i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				
				if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
				if(map[nx][ny] == '#' || fire[nx][ny] != 0) continue;
				fire[nx][ny] = fire[nowX][nowY] + 1;
				qFire.offer(new int[] {nx,ny});
			}
		}
	}
	
	public static void bfs() {
		while(!qJ.isEmpty()) {
			int[] now = qJ.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0;i<4;i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(nx<0 || nx>= r || ny<0 || ny>=c) {
					System.out.println(visited[nowX][nowY]);
					check = true;
					return;
				}
				if(visited[nx][ny] != 0 || map[nx][ny] == '#') continue;
				
				if(fire[nx][ny] == 0 || visited[nowX][nowY] + 1 < fire[nx][ny]) {
					visited[nx][ny] = visited[nowX][nowY] + 1;
					qJ.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	r = sc.nextInt();
    	c = sc.nextInt();
    	
    	map = new char[r][c];
    	visited = new int[r][c];
    	fire = new int[r][c];
    	
    	for(int i=0;i<r;i++) {
    		String str = sc.next();
    		for(int j=0;j<c;j++) {
    			map[i][j] = str.charAt(j);
    			if(map[i][j] == 'F') {
    				qFire.offer(new int[] {i,j});
    				fire[i][j] = 1;
    			}
    			if(map[i][j] == 'J') {
    				qJ.offer(new int[] {i,j});
    				visited[i][j] = 1;
    			}
    		}
    	}
    	
    	firebfs();
    	bfs();
    	
    	if(!check) System.out.println("IMPOSSIBLE");
    	
    }
}