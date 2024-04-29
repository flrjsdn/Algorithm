import java.util.*;
import java.io.*;

public class Main {
	public static int[] arr;
	public static int n;
	public static int result = 0;
	public static void dfs(int depth) {
		if(depth == n) {
			result++;
			return;
		}
		for(int i=0;i<n;i++) {
			arr[depth] = i;
			if(isPossible(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean isPossible(int depth) {
		for(int i=0;i<depth;i++) {
			if(arr[i] == arr[depth] || Math.abs(depth-i) == Math.abs(arr[depth] - arr[i])) {
				return false;
			}
		}
		return true;
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	arr = new int[n];
    	dfs(0);
    	System.out.println(result);
    }
}