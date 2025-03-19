import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static final int INF = (int) 1e9;
	static class Node implements Comparable<Node>{
		int index;
		int weight;
		
		public Node(int index,int weight) {
			this.index = index;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
	static int[] dist;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		dist = new int[n+1];
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			int a = read();
			int b = read();
			int w = read();
			graph.get(a).add(new Node(b,w));
			graph.get(b).add(new Node(a,w));
		}
		
		Arrays.fill(dist, INF);
		int s = read();
		int t = read();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			if(dist[now.index] < now.weight) continue;
			
			for(Node next : graph.get(now.index)) {
				int cost = dist[now.index] + next.weight;
				if(dist[next.index] > cost) {
					dist[next.index] = cost;
					pq.add(new Node(next.index, cost));
				}
			}
		}
		
		System.out.println(dist[t]);
	}
}
