import java.io.*;
import java.util.*;


public class Main {
	public static final int INF = (int)1e9;
	public static int[][] arr;
	public static boolean[] visited;
	public static int n;
	
	public static int bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		
		visited[start] = true;
		
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=1;i<=n;i++) { //그룹 찾기
				if(arr[now][i] != INF && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					arrList.add(i);
				}
			}
		}
		int idx = -1;
		int max = INF;
		for(int i=1;i<=n;i++) { //가장 작은 부분 찾기
			if(!arrList.contains(i)) continue;
			
			int sum = 0;
			for(int j=1;j<=n;j++) {
				if(!arrList.contains(j)) continue;
				sum = Math.max(sum, arr[i][j]);
			}
			
			if(max > sum) {
				max = sum;
				idx = i;
			}
		}
		
		return idx;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i!=j) arr[i][j] = INF;
			}
		}
		StringTokenizer st;
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x][y] = arr[y][x] = 1;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			if(!visited[i]) {
				result.add(bfs(i));
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(result.size()).append("\n");
		
		Collections.sort(result);
		for(int i=0;i<result.size();i++) {
			sb.append(result.get(i)).append("\n");
		}
		
		System.out.println(sb);
    }
}