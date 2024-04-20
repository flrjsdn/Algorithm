
import java.util.*;
public class Main {
	public static int testCase, n,m, k;
	public static int result;
	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] arr = q.poll();
			int nowX = arr[0];
			int nowY = arr[1];
			for(int i=0;i<4;i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(nx>=0 && nx<n && ny>=0 && ny<m && !visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int tc = 0;tc<testCase;tc++) {
			result = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			map = new int[n][m];
			visited = new boolean[n][m];
			for(int i=0;i<k;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						result++;
						bfs(i,j);
					}
				}
			}
			System.out.println(result);
		}
	}
}
