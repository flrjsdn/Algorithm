import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	

	static int n;
	static ArrayList<int[]> list = new ArrayList<>();
	static boolean flag = false;
	
	static void dfs(int depth, int[][] map) {
		if(depth == list.size()) {
			printMap(map);
			flag = true;
			return;
		}
		if(flag) return;
		
		boolean[] visited = new boolean[10];
		
		int[] now = list.get(depth);
		int nx = now[0];
		int ny = now[1];
		
		for(int i=0;i<n;i++) {
			if(map[nx][i] != 0) visited[map[nx][i]] = true;
		}
		
		for(int i=0;i<n;i++) {
			if(map[i][ny] != 0) visited[map[i][ny]] = true;
		}
		
		int sX = (nx / 3) * 3;
		int sY = (ny / 3) * 3;
		
		for(int i=sX;i<sX+3;i++) {
			for(int j=sY;j<sY+3;j++) {
				if(map[i][j] != 0) visited[map[i][j]] = true;
			}
		}
		
		for(int i=1;i<=9;i++) {
			if(!visited[i]) {
				map[nx][ny] = i;
				dfs(depth+1, map);
				map[nx][ny] = 0;
			}
		}
	}
	
	static void printMap(int[][] map) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws Exception {
		n = 9;
		int[][] map = new int[n][n];
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j] = s.charAt(j) - '0';
				if(map[i][j] == 0) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		dfs(0, map);
	}
}