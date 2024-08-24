import java.io.*;
import java.util.*;

class Node {
	int pos;
	int cost;
	
	public Node(int pos, int cost) {
		this.pos = pos;
		this.cost = cost;
	}
}

public class Main {
	public static ArrayList<ArrayList<Node>> list, tree;
	public static int result;
	public static boolean[] visited;
	
	public static boolean dfs(int curNode, int p, int sum) {
		visited[curNode] = true;
		if(curNode == p) {
			result = sum;
			return true;
		}
		
		for(int i=0;i<list.get(curNode).size();i++) {
			Node node = list.get(curNode).get(i);
			if(!visited[node.pos]) {
				if(dfs(node.pos, p, sum + node.cost)) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		tree = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			list.add(new ArrayList<>());
			tree.add(new ArrayList<>());
		}
		
		for(int i=1;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		

		StringBuilder sb = new StringBuilder();
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			result = 0;
			visited = new boolean[n+1];
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			boolean check = dfs(a,b,0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
    }
}
