import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static int n;
	static boolean feeling;
	static ArrayList<int[]> arr;
	static boolean[] visited;
	static int fX,fY;
	
	static void bfs(int x, int amount) {
		visited[x] = true;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == arr.size()-1) {
				feeling = true;
				return;
			}
			for(int i=1;i<arr.size();i++) {
				if(!visited[i]) {
					int dist = Math.abs(arr.get(i)[0] - arr.get(now)[0]) + Math.abs(arr.get(i)[1] - arr.get(now)[1]);
					if(dist <= 1000) {
						visited[i] = true;
						q.add(i);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int T = read();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			n = read();
			arr = new ArrayList<>();
			int sX = read();
			int sY = read();
			arr.add(new int[] {sX,sY});
			
			for(int i=0;i<n;i++) {
				int x = read();
				int y = read();
				arr.add(new int[] {x,y});
			}
			
			fX = read();
			fY= read();
			arr.add(new int[] {fX,fY});
			visited = new boolean[arr.size()];
			feeling = false;
			
			bfs(0, 1000);
			if(feeling) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}
}