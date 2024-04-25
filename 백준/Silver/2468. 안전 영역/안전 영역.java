
import java.util.*;
import java.io.*;
public class Main {
	public static int[][] map;
	public static int resultNum, n;
	public static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public static boolean[][] visited;
	public static ArrayList<Integer> result = new ArrayList<>();
	
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void bfs(int x, int y, int h) {
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
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny] > h && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) max = map[i][j];
				if(map[i][j] < min) min = map[i][j];
			}
		}
		
		for(int h=min;h<=max;h++) {
			visited = new boolean[n][n];
			int cnt=0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] > h && !visited[i][j]) {
						cnt++;
						bfs(i,j,h);
					}
				}
			}
			result.add(cnt);
		}
		Collections.sort(result);
		if(min == max) System.out.println(1);
		else System.out.println(result.get(result.size()-1));
	}
}
