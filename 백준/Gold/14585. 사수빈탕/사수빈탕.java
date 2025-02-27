import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		boolean[][] map = new boolean[301][301];
		for(int i=0;i<n;i++) {
			int x = read();
			int y = read();
			map[x][y] = true;
		}
		long[][] dp = new long[301][301];
		int cal = 0;
		for(int i=0;i<=300;i++) {
			for(int j=0;j<=300;j++) {
				cal = (m-i-j) <= 0 ? 0 : (m-i-j);
				if(i==0 && j==0) continue;
				if(i==0) {
					if(map[i][j]) {
						dp[i][j] = dp[i][j-1] + cal;
					} else {
						dp[i][j] = dp[i][j-1];
					}
				}
				else if(j==0) {
					if(map[i][j]) {
						dp[i][j] = dp[i-1][j] + cal;
					} else {
						dp[i][j] = dp[i-1][j];
					}
				}
				else {
					if(map[i][j]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + cal;
					} else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					}
				}
			}
		}
		System.out.println(dp[300][300]);
	}
}
