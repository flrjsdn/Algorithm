
import java.util.*;
import java.io.*;

public class Main {
	public static int[] arr;
	public static int n,s;
	public static int cnt = 0;
	public static void dfs(int depth, int sum) {
		if(depth == n) {
			if(sum == s) cnt++;
			return;
		}
		dfs(depth+1, sum+arr[depth]);
		dfs(depth+1, sum);
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	s = sc.nextInt();
    	arr = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	dfs(0,0);
    	if(s==0) System.out.println(cnt-1);
    	else System.out.println(cnt);
    }
}