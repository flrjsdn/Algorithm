import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static class Node{
		int child;
		int weight;
		
		Node(int child, int weight) {
			this.child = child;
			this.weight = weight;
		}
	}
	
	static ArrayList<ArrayList<Node>> graph;
	static int n;
	static int max;
	static boolean[] visited;
	static int findNode;

	static void dfs(int index,int sum) {
		visited[index] = true;
		if(sum > max) {
			max = sum;
			findNode = index;
		}
		
		for(Node now : graph.get(index)) {
			if(!visited[now.child]) {
				dfs(now.child, sum + now.weight);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		n = read();
		graph = new ArrayList<ArrayList<Node>>();
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<n-1;i++) {
			int p = read();
			int c = read();
			int w = read();
			
			graph.get(p).add(new Node(c,w));
			graph.get(c).add(new Node(p,w));
		}
		visited = new boolean[n+1];
		max = 0;
		findNode = 1;
		dfs(1,0);
		max = 0;
		visited = new boolean[n+1];
		dfs(findNode, 0);
		
		System.out.println(max);
    }
}
