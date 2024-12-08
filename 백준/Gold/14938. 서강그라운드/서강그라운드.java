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
		int r = read();
		int[] score = new int[n+1];
		for(int i=1;i<=n;i++) {
			score[i] = read();
		}
		
		int[][] map = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = INF;
			}
		}
		
		for(int i=0;i<r;i++) {
			int a = read();
			int b = read();
			int w = read();
			map[a][b] = w;
			map[b][a] = w;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(i==j) continue;
					if(map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
						map[j][i] = map[i][k] + map[k][j];
					}
				}
			}
		}
		int result = 0;
		for(int i=1;i<=n;i++) {
			int sum  = score[i];
			for(int j=1;j<=n;j++) {
				if(map[i][j] <= m) sum += score[j];
			}
			result  = Math.max(result, sum);
		}
		System.out.println(result);
    }
}
