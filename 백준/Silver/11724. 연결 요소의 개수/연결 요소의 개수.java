import java.util.*;
import java.io.*;

public class Main {
	public static int n,m;
	public static boolean[] visited;
	public static int result = 0;
	public static int[][] arr;
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for(int i=1;i<=n;i++) {
			if(arr[x][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	m = sc.nextInt();
    	visited = new boolean[n+1];
    	arr = new int[n+1][n+1];
    	
    	for(int i=0;i<m;i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		arr[a][b] = 1;
    		arr[b][a] = 1;
    	}
    	
    	for(int i=1;i<=n;i++) {
    		if(!visited[i]) {
    			dfs(i);
    			result++;
    		}
    	}
    	System.out.println(result);
    }
}