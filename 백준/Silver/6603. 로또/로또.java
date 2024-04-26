
import java.util.*;
import java.io.*;

public class Main {
	public static int[] arr;
	public static boolean[] visited;
	public static int[] result;
	public static StringBuilder sb = new StringBuilder();
	
	public static void dfs(int[] result, int depth, int index) {
		if(depth == 6) {
			for(int i=0;i<6;i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i=index;i<arr.length;i++) {
			visited[i] = true;
			result[depth] = arr[i];
			dfs(result, depth+1, i+1);
			visited[i] = false;
		}
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int k = -1;
    	while(k!=0) {
    		k = sc.nextInt();
    		arr = new int[k];
    		visited = new boolean[k];
    		int[] result = new int[6];
    		for(int i=0;i<k;i++) {
    			arr[i] = sc.nextInt();
    		}
    		
    		dfs(result, 0,0);
    		System.out.println();
    	}
    }
}
