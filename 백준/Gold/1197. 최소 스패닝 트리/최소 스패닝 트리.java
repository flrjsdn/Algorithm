import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int pos1;
	int pos2;
	int cost;
	
	public Node(int pos1,int pos2, int cost) {
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.cost, other.cost);
	}
}

public class Main {
	public static int[] parent;
	
	public static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int result = 0;
		parent = new int[v+1];

		for(int i=1;i<=v;i++) {
			parent[i] = i;
		}
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			pq.add(new Node(a,b,c));
		}
		
		int cnt = 1;
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nA = now.pos1;
			int nB = now.pos2;
			if(findParent(nA) != findParent(nB)) {
				unionParent(nA, nB);
				result += now.cost;
				cnt++;
			}
			if(cnt == v) break;
		}
		System.out.println(result);
    }
}
