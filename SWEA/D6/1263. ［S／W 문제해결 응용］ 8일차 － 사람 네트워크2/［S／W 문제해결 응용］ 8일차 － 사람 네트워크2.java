import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws Exception {
		int T = read();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int n = read();
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = read();
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(i!=j && map[i][j] == 0) map[i][j] = INF;
				}
			}
			
			for(int k=0;k<n;k++) {
				for(int i=0;i<n;i++) {
					for(int j=0;j<n;j++) {
						if(map[i][j] > map[i][k] + map[k][j]) {
							map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
						}
					}
				}
			}
			

			int ans = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				int sum = 0;
				for(int j=0;j<n;j++) {
					if(map[i][j] == INF) continue;
					sum += map[i][j];
					if(sum > ans) break;
				}
				ans = Math.min(ans, sum);
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}