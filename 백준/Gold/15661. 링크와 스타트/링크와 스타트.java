import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static boolean[] visited;
	static int n;
	static int[][] w;
	static int result;
	
	static void dfs(int depth, int team) {
		if(depth == n) {
			result = Math.min(result, cal(team));
			return;
		}
		
		dfs(depth+1, team | 1<<depth);
		dfs(depth+1, team);
	}
	
	static int cal(int team) {
		int t1 = 0;
		int t2 = 0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if((team & (1<<i)) == 0 && (team & (1<<j)) ==0) {
					t1 += w[i][j] + w[j][i];
				}
				else if((team & (1<<i)) != 0 && (team & (1<<j)) != 0) {
					t2 += w[i][j] + w[j][i];
				}
			}
		}
		
		return Math.abs(t1-t2);
	}
	public static void main(String[] args) throws Exception {
		n = read();
		visited = new boolean[n];
		w = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				w[i][j] = read();
			}
		}
		
		result = Integer.MAX_VALUE;
		dfs(0,0);
		System.out.println(result);
    }
}
