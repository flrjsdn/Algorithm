import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
	public int pos;
	public int cost;
	
	public Node(int pos, int cost) {
		this.pos = pos;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.cost, other.cost);
	}
}

public class Main {
	public static int v;
	public static ArrayList<Node>[] graph;
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void dijkstra(int[] distance) {
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			for(int i=0;i<graph[node.pos].size();i++) {
				Node next = graph[node.pos].get(i);
				
				if(distance[next.pos] > next.cost + node.cost) {
					pq.add(new Node(next.pos, next.cost+node.cost));
					distance[next.pos] = next.cost + node.cost; 
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		graph = new ArrayList[v+1];
		for(int i=1;i<=v;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b,cost));
			graph[b].add(new Node(a, cost));
		}
		
		int[] mac = new int[v+1];
		for(int i=0;i<=v;i++) {
			mac[i] = Integer.MAX_VALUE;
		}
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int macMin = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(st.nextToken());
			mac[m] = 0;
			pq.add(new Node(m,0));
		}
		
		dijkstra(mac);
		
		int[] star = new int[v+1];
		for(int i=0;i<=v;i++) {
			star[i] = Integer.MAX_VALUE;
		}
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int starMin = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int s = Integer.parseInt(st.nextToken());
			star[s] = 0;
			pq.add(new Node(s,0));
		}
		
		dijkstra(star);
		
		int result = Integer.MAX_VALUE;
		for(int i=1;i<=v;i++) {
			if(mac[i]>0 && mac[i]<=macMin && star[i]<=starMin && star[i] > 0) {
				result = Math.min(result, mac[i] + star[i]);
			}
		}
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
    }
}
