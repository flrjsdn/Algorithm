
import java.util.*;
public class Main {
	public static int n;
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

				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny] == 1 && !visited[nx][ny]) {
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
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			String str = sc.next();
			for(int j=0;j<n;j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i,j);
					result++;
				}
			}
		}
		System.out.println(result);
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
	}
}
