import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static int[] size;
	static ArrayList<ArrayList<Integer>> graph;
	static int deleteNode;
	static boolean[] visited;
	
	static void dfs(int node) {
		size[node] = 1;
		visited[node] = true;
		
		for(int next : graph.get(node)) {
			if(next != deleteNode && !visited[next]) {
				dfs(next);
				size[node] += size[next];
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int n =read();
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[n];
		size = new int[n];
		int root = -1;
		for(int i=0;i<n;i++) {
			int x = read();
			if(x == -1) root = i;
			else graph.get(x).add(i);
		}
		deleteNode = read();
		dfs(root);
		int cnt = 0;
		for(int i=0;i<n;i++) {
			if(size[i] == 1) cnt++;
		}
		if(deleteNode == root) System.out.println(0);
		else System.out.println(cnt);
		
    }
}
