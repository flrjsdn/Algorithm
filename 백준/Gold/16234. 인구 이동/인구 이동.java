import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static final int INF = (int) 1e9;
	static boolean[][] visited;
	static int[][] map;
	static int[][] newMap;
	static int n,l,r;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean flag;
	
	static void bfs(int x,int y) {
		visited[x][y] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		ArrayList<int[]> arr = new ArrayList<>();
		arr.add(new int[] {x,y,map[x][y]});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				int diff = Math.abs(map[now[0]][now[1]] - map[nx][ny]);
				if(!visited[nx][ny] && diff>=l && diff<=r) {
					arr.add(new int[] {nx,ny,map[nx][ny]});
					q.add(new int[] {nx,ny});
					visited[nx][ny] = true;
					flag = true;
				}
			}
		}
		
		int sum = 0;
		for(int[] now : arr) {
			sum += now[2];
		}
		sum /= arr.size();
		for(int[] now : arr) {
			newMap[now[0]][now[1]] = sum;
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		n = read();
		l = read();
		r = read();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = read();
			}
		}
		
		int result = 0;
		while(true) {
			flag = false;
			visited = new boolean[n][n];
			newMap = new int[n][n];
			for(int i=0;i<n;i++) {
				newMap[i] = Arrays.copyOf(map[i], n);
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(!visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			
			if(!flag) break;
			for(int i=0;i<n;i++) {
				map[i] = Arrays.copyOf(newMap[i], n);
			}
			result += 1;
		}
		System.out.println(result);
    }
}
