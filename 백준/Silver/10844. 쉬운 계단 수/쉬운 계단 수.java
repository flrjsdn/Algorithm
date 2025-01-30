import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static final long MOD = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		int n = read();
		long[][] dp = new long[n+1][10];
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					dp[i][0] = dp[i-1][1] % MOD;
				} else if(j==9) {
					dp[i][9] = dp[i-1][8] % MOD;
				} else {
					dp[i][j] += (dp[i-1][j+1] + dp[i-1][j-1]) % MOD;
				}
			}
		}
		
		long sum = 0;
		for(int i=0;i<10;i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % MOD);
    }
}
