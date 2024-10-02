import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine().trim());
		return Integer.parseInt(st.nextToken());
	}
	
	static int[] dx = {1,-1,0,0}; //하,상,우,좌
	static int[] dy = {0,0,1,-1};
	static ArrayList<int[]>[] list;
	static int[][] map;
	static int bX, bY;
	static int n;
	
	static int changeDirection(int num, int d) {
		switch(num) {
		case 1:
			if(d==0) return 2;
			else if(d==1) return 0;
			else if(d==2) return 3;
			else if(d==3) return 1;
			break;
		case 2:
			if(d==0) return 1;
			else if(d==1) return 2;
			else if(d==2) return 3;
			else if(d==3) return 0;
			break;
		case 3:
			if(d==0) return 1;
			else if(d==1) return 3;
			else if(d==2) return 0;
			else if(d==3) return 2;
			break;
		case 4:
			if(d==0) return 3;
			else if(d==1) return 0;
			else if(d==2) return 1;
			else if(d==3) return 2;
			break;
		case 5:
			if(d==0) return 1;
			else if(d==1) return 0;
			else if(d==2) return 3;
			else if(d==3) return 2;
			break;
		}
		return -1;
	}
	
	static int dfs(int x,int y, int direction) {
		int result = 0;
		int nx = x;
		int ny = y;
		while(true) {
			nx += dx[direction];
			ny += dy[direction];
			if(!check(nx,ny)) { //벗어나면 반대 방향으로
				nx -= dx[direction];
				ny -= dy[direction];
				result++;
				if(nx == x && ny == y) break;
				direction = changeDirection(5, direction);
				if(map[nx][ny] >= 1 && map[nx][ny] <= 5) {
					direction = changeDirection(map[nx][ny], direction);
					result++;
					continue;
				}
				if(map[nx][ny] >=6) {
					for(int[] now : list[map[nx][ny]]) {
						if(now[0] != nx || now[1] != ny) {
							nx = now[0];
							ny = now[1];
							break;
						}
					}
				}
				continue;
			}
			
			if(nx == x && ny == y) break;
			if(map[nx][ny] == -1) break;
			
			if(map[nx][ny] == 0) continue;
			if(map[nx][ny] >= 1 && map[nx][ny] <= 5) {
				direction = changeDirection(map[nx][ny], direction);
				result++;
				continue;
			}
			
			if(map[nx][ny] >=6) {
				for(int[] now : list[map[nx][ny]]) {
					if(now[0] != nx || now[1] != ny) {
						nx = now[0];
						ny = now[1];
						break;
					}
				}
			}
			
		}
		
		return result;
	}
	
	static boolean check(int x,int y) {
		return x>=0 && x<n && y>=0 && y<n;
	}
	
	public static void main(String[] args) throws Exception {
		int T = read();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			n = read();
			list = new ArrayList[11];
			for(int i=0;i<11;i++) {
				list[i] = new ArrayList<>();
			}
			
			map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = read();
					if(map[i][j] >= 6) {
						list[map[i][j]].add(new int[] {i,j});
					}
				}
			}
			
			int ans = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j] == 0) {
						for(int k=0;k<4;k++) {
							ans = Math.max(ans, dfs(i,j,k));
						}
					}
				}
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}