import java.util.*;
import java.io.*;

public class Main {
	public static int n,m;
	public static int[] visited;
	public static int[][] arr;
	public static int result = 0;
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		visited[x] = 1;
		q.offer(x);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1;i<=n;i++) {
				if(arr[now][i] == 1 && visited[i] == 0) {
					visited[i] = visited[now] + 1;
					if(visited[i] < 4) {
						q.offer(i);
						result++;
					}
				}
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	m = sc.nextInt();
    	arr = new int[n+1][n+1];
    	visited = new int[n+1];
    	
    	for(int i=0;i<m;i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		arr[a][b] = arr[b][a] = 1;
    	}
    	
    	bfs(1);
    	System.out.println(result);
    }
}