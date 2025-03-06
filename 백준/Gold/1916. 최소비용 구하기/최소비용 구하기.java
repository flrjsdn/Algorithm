import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static class Node implements Comparable<Node>{
		int next;
		int w;
		
		public Node(int next, int w) {
			this.next = next;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.w, other.w);
		}
	}
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	static int[] visited;
	static final int INF = (int) 1e9;
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		visited = new int[n+1];
		Arrays.fill(visited, INF);
		for(int i=0;i<m;i++) {
			int a = read();
			int b = read();
			int c = read();
			graph.get(a).add(new Node(b,c));
		}
		int start = read();
		int end = read();
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start,0));
		visited[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(visited[now.next] < now.w) continue; 
			for(Node next : graph.get(now.next)) {
				int cost = visited[now.next] + next.w;
				if(visited[next.next] > cost) {
					visited[next.next] = cost;
					pq.add(new Node(next.next, cost));
				}
			}
		}
		System.out.println(visited[end]);
	}
}
