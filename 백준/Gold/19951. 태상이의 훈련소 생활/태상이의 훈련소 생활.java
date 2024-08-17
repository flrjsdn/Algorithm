import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] dp = new int[n+2];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			dp[a] += k;
			dp[b+1] += -k;
		}
		
		for(int i=1;i<=n;i++) {
			dp[i] += dp[i-1];
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			arr[i] += dp[i];
			sb.append(arr[i]).append(" ");
		}
		
		System.out.println(sb);
    }
}
