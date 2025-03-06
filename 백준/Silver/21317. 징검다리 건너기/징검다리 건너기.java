import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static final int INF = (int) 1e9;
	public static void main(String[] args) throws Exception {
		int n = read();
		int[][] stone = new int[n+1][2];
		for(int i=1;i<n;i++) {
			stone[i][0] = read();
			stone[i][1] = read();
		}
		
		int k = read();
		
		int[][] dp = new int[n+1][2];
		for(int i=1;i<=n;i++) {
			Arrays.fill(dp[i], INF);
		}
		
		dp[1][0] = 0;
		if(n >= 2) {
			dp[2][0] = stone[1][0];
		}
		if(n >= 3) {
			dp[3][0] = Math.min(dp[2][0] + stone[2][0], stone[1][1]);
		}
		for(int i=4;i<=n;i++) {
			dp[i][0] = Math.min(dp[i-1][0] + stone[i-1][0], dp[i-2][0] + stone[i-2][1]);
			dp[i][1] = Math.min(dp[i-3][0] + k, Math.min(dp[i-1][1] + stone[i-1][0], dp[i-2][1] + stone[i-2][1]));
		}
		
		if(n<=3) System.out.println(dp[n][0]);
		else System.out.println(Math.min(dp[n][0], dp[n][1]));
		
	}
}
