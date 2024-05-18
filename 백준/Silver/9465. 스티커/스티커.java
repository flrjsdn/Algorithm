import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];
			
			for(int i=0;i<2;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[1][0] = arr[1][0];
			if(n >= 2) {
				dp[0][1] = dp[1][0] + arr[0][1];
				dp[1][1] = dp[0][0] + arr[1][1];
			}
			
			for(int i=2;i<n;i++) {
				int s = Math.max(dp[0][i-2], dp[1][i-2]);
				dp[0][i] = Math.max(dp[1][i-1] + arr[0][i], s+arr[0][i]);
				dp[1][i] = Math.max(dp[0][i-1] + arr[1][i], s+arr[1][i]);
			}
			int result = Math.max(dp[0][n-1], dp[1][n-1]);
			System.out.println(result);
		}
	}
}