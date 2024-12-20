import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static final int INF = (int) 1e9;
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		int[][] map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = read();
			}
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int p=0;p<m;p++) {
			int a = read();
			int b = read();
			int t = read();
			if(map[a][b] <= t) sb.append("Enjoy other party\n");
			else sb.append("Stay here\n");
		}
		System.out.println(sb);
    }
}
