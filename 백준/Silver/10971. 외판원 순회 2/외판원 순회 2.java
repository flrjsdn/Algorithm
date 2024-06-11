
import java.util.*;
import java.io.*;

class Main {
	public static int result = Integer.MAX_VALUE;
	public static int n;
	public static int[][] w;
	public static boolean[] visited;
	
	public static void dfs(int depth, int sum, int before, int start) {
		if(depth == n) {
			for(int i=0;i<n;i++) {
				if(w[before][start] != 0) {
					result = Math.min(result, sum + w[before][start]);
				}
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i] && w[before][i] != 0) {
				visited[i] = true;
				dfs(depth+1, sum+w[before][i], i, start);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<n;i++) {
			visited = new boolean[n];
			visited[i] = true;
			dfs(1,0,i, i);
		}
		
		System.out.println(result);
	}
}