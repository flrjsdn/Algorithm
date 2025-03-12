import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static int[] dx = {1,-1,0,0,0,0};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static boolean[][][] visited;
	static char[][][] map;
	static int l,r,c;
	static int ans;
	static void bfs(int x,int y,int z) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[z][x][y] = true;
		q.add(new int[] {x,y,z, 0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(map[now[2]][now[0]][now[1]] == 'E') {
				ans = now[3];
				break;
			}
			for(int i=0;i<6;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				int nz = now[2] + dz[i];
				if(nx<0 || nx>=r || ny<0 || ny>=c || nz<0 || nz>=l) continue;
				
				if(!visited[nz][nx][ny] && map[nz][nx][ny] != '#') {
					visited[nz][nx][ny] = true;
					q.add(new int[] {nx,ny,nz, now[3] + 1});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		while(true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if(l==0 && r==0 && c==0) break;
			
			map = new char[l][r][c];
			visited = new boolean[l][r][c];
			int sX=0, sY=0, sZ=0;
			for(int k=0;k<l;k++) {
				for(int i=0;i<r;i++) {
					String s = br.readLine();
					for(int j=0;j<c;j++) {
						map[k][i][j] = s.charAt(j);
						if(s.charAt(j) == 'S') {
							sX = i;
							sY = j;
							sZ = k;
						}
					}
				}
				br.readLine();
			}
			ans = 0;
			bfs(sX,sY,sZ);
			if(ans == 0) System.out.println("Trapped!");
			else System.out.println("Escaped in " + ans + " minute(s).");
		}
	}
}
