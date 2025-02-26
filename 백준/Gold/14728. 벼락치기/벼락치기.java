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
		int T = read();
		int[] study = new int[n+1];
		int[] score = new int[n+1];
		for(int i=1;i<=n;i++) {
			study[i] = read();
			score[i] = read();
		}
		int[][] dp = new int[n+1][T+1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=T;j++) {
				dp[i][j] = dp[i-1][j];
				if(j-study[i] >=0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-study[i]] + score[i]);
				}
			}
		}
		System.out.println(dp[n][T]);
		
	}
}
