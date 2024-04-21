
import java.util.*;
public class Main {
	public static int n;
	public static int result = 0, rgResult = 0;
	public static char[][] map;
	public static boolean[][] visited1;
	public static boolean[][] visited2;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void bfs(int x,int y, char c) {
		Queue<int[]> q = new LinkedList<>();
		visited1[x][y] = true;
		q.offer(new int[] {x,y});
		result++;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0;i<4;i++) {
				int nx = nowX+dx[i];
				int ny = nowY+dy[i];
				if(nx>=0&&nx<n&&ny>=0 && ny<n && map[nx][ny]== c && !visited1[nx][ny]) {
					visited1[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	
	public static void bfs(int x,int y, char a, char b) {
		Queue<int[]> q = new LinkedList<>();
		visited2[x][y] = true;
		q.offer(new int[] {x,y});
		rgResult++;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0;i<4;i++) {
				int nx = nowX+dx[i];
				int ny = nowY+dy[i];
				if(nx>=0&&nx<n&&ny>=0 && ny<n && !visited2[nx][ny]) {
					if(map[nx][ny] == a || map[nx][ny] == b) {
						visited2[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 'R' && !visited1[i][j]) {
					bfs(i,j,'R');
				}
				if(map[i][j] == 'R' && !visited2[i][j]) {
					bfs(i,j,'R', 'G');
				}
				if(map[i][j] == 'G' && !visited1[i][j]) {
					bfs(i,j,'G');
				}
				if(map[i][j] == 'G' && !visited2[i][j]) {
					bfs(i,j,'R', 'G');
				}
				if(map[i][j] == 'B' && !visited1[i][j]) {
					bfs(i,j,'B');
				}
				if(map[i][j] == 'B' && !visited2[i][j]) {
					bfs(i,j,'B','.');
				}
			}
		}
		System.out.println(result + " " + rgResult);
	}
}
