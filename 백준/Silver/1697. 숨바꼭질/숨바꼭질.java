import java.util.*;
public class Main {
	public static int N,M;
	public static int minResult = -1;
	public static int[] visited = new int[100001];
	
	public static int dfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		int n = 0;
		visited[x] = 1;
		while(!q.isEmpty()) {
			n = q.poll();
			if(n == M) {
				return visited[n] -1;
			}
			if(n-1 >= 0 && visited[n-1] == 0) {
				visited[n-1] = visited[n] + 1;
				q.add(n-1);
			}
			if(n+1 <= 100000 && visited[n+1] == 0) {
				visited[n+1] = visited[n] + 1;
				q.add(n+1);
			}
			if(2*n <= 100000 && visited[2*n] == 0) {
				visited[2*n] = visited[n] + 1;
				q.add(2*n);
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int result = dfs(N);
		System.out.println(result);
	}
}
