import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node implements Comparable<Node>{
		int time;
		int dps;
		
		public Node(int time, int dps) {
			this.time = time;
			this.dps = dps;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.time, other.time);
		}
	}
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int m,n;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Node> result = new ArrayList<>();
	
	static void bfs(int x,int y, int dps) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.add(new int[] {x,y, 0});
		
		s : while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || nx>=m || ny<0 || ny>=n) continue;
				if(map[nx][ny] == 'B') {
					result.add(new Node(now[2] + 1, dps));
					min = Math.min(now[2] + 1, min);
					break s;
				}
				if(!visited[nx][ny] && map[nx][ny] != 'X') {
					q.add(new int[] {nx,ny,now[2]+1});
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		map = new char[m][n];
		for(int i=0;i<m;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int player=0;player<p;player++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int dps = Integer.parseInt(st.nextToken());
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == c) {
						visited = new boolean[m][n];
						bfs(i,j,dps);
					}
				}
			}
		}
		int boss = Integer.parseInt(br.readLine());
		int dps = 0;
		int ans = 0;
		Collections.sort(result, Collections.reverseOrder());
		while(true) {
			for(int i=result.size()-1;i>=0;i--) {
				Node now = result.get(i);
				if(now.time == min) {
					dps += now.dps;
					result.remove(i);
					ans += 1;
				}else {
					min++;
					break;
				}
			}
			boss -= dps;
			if(boss <= 0) {
				break;
			}
		}
		System.out.println(ans);
    }
}
