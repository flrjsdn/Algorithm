import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		int[] dp = new int[k+1];
		for(int i=0;i<n;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x>k) continue;
			dp[x] += 1;
			for(int j=1;j<=k;j++) {
				if(j-x >= 1) dp[j] += dp[j-x];
			}
		}
		
		System.out.println(dp[k]);
    }
}