import java.util.*;
import java.io.*;

public class Main {
	public static int n,m,v;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph;
	
	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + " ");
		for(int i=0;i<graph.get(x).size();i++) {
			if(!visited[graph.get(x).get(i)]) {
				dfs(graph.get(x).get(i));
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = true;
		System.out.print(x + " ");
		q.offer(x);
		while(!q.isEmpty()) {
			 int now = q.poll();
			 for(int i=0;i<graph.get(now).size();i++) {
				 if(!visited[graph.get(now).get(i)]) {
					 visited[graph.get(now).get(i)] = true;
					 System.out.print(graph.get(now).get(i) + " ");
					 q.offer(graph.get(now).get(i));
				 }
			 }
		}
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	m = sc.nextInt();
    	v = sc.nextInt();
    	visited = new boolean[n+1];
    	graph = new ArrayList<ArrayList<Integer>>();
    	for(int i=0;i<=n;i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<m;i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		graph.get(a).add(b);
    		graph.get(b).add(a);
    	}
    	for(int i=0;i<=n;i++) {
    		Collections.sort(graph.get(i));
    	}
    	dfs(v);
    	System.out.println();
    	visited = new boolean[n+1];
    	bfs(v);
    }
}