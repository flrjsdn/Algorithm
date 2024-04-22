
import java.util.*;
public class Main {
	public static int m,n,k;
	public static int result = 0;
	public static boolean[][] visited;
	public static int[][] map;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void bfs(int x,int y) {
		int cnt=1;
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0;i<4;i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];

				if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny] == 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
					cnt++;
				}
			}
		}
		arr.add(cnt);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		for(int i=0;i<k;i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			for(int j=x1;j<x2;j++) {
				for(int v=y1;v<y2;v++) {
					map[j][v] = 1;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					bfs(i,j);
					result++;
				}
			}
		}
		Collections.sort(arr);
		System.out.println(result);
		for(int i=0;i<arr.size();i++) {
			System.out.print(arr.get(i) + " ");
		}
	}
}
