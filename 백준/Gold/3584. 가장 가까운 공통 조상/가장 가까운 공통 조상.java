import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static int ans;
	static void dfs(int node) {
		visited[node] = true;
		
		for(int next : graph.get(node)) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
	
	static void dfs2(int node) {
		visited[node] = true;
		
		for(int next : graph.get(node)) {
			if(!visited[next]) {
				dfs2(next);
			} else {
				ans = next;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		int T = read();
		for(int tc=1;tc<=T;tc++) {
			ans = 0;
			graph = new ArrayList<ArrayList<Integer>>();
			int n = read();
			visited = new boolean[n+1];
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<n-1;i++) {
				int a = read();
				int b = read();
				graph.get(b).add(a);
			}
			
			int a = read();
			int b = read();
			dfs(a);
			if(visited[b]) {
				System.out.println(b);
			} else {
				dfs2(b);
				System.out.println(ans);
			}
		}
	}
}
