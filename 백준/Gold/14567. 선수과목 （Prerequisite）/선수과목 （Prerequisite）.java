import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		int[] indegree = new int[n+1];
		
		for(int i=0;i<m;i++) {
			int a = read();
			int b = read();
			graph.get(a).add(b);
			indegree[b] += 1;
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0) {
				q.add(new int[] {i,1});
			}
		}
		
		int[] result = new int[n+1];
		while(!q.isEmpty()) {
			int[] now = q.poll();
			result[now[0]] = now[1];
			
			for(int i=0;i<graph.get(now[0]).size();i++) {
				int next = graph.get(now[0]).get(i);
				indegree[next] -= 1;
				if(indegree[next] == 0) {
					q.add(new int[] {next, now[1]+1});
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.print(result[i] + " ");
		}
    }
}
