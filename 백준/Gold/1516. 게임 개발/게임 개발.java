import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		int n = read();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		int[] indegree = new int[n+1];
		int[] time = new int[n+1];
		int[] result = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1;i<=n;i++) {
			int t = read();
			time[i] = result[i] = t;
			while(true) {
				int s = read();
				if(s == -1) break;
				graph.get(s).add(i);
				indegree[i] += 1;
			}
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int next : graph.get(now)) {
				indegree[next] -= 1;
				result[next] = Math.max(time[next] + result[now], result[next]);
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		for(int i=1;i<=n;i++) {
			System.out.println(result[i]);
		}
    }
}
