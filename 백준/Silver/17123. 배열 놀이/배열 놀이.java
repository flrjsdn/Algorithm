import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			int[] row = new int[n];
			int[] col = new int[n];
			
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					row[i] += map[i][j];
					col[j] += map[i][j];
				}
			}
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken()) - 1;
				int y1 = Integer.parseInt(st.nextToken()) -1 ;
				int x2 = Integer.parseInt(st.nextToken())-1;
				int y2 = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				
				for(int j=x1;j<=x2;j++) {
					row[j] += (y2-y1+1) * v;
				}
				
				for(int j=y1;j<=y2;j++) {
					col[j] += (x2-x1+1) * v;
				}
				
			}
			
			for(int i=0;i<n;i++) {
				sb.append(row[i]).append(" ");
			}
			sb.append("\n");
			for(int i=0;i<n;i++) {
				sb.append(col[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
    }
}
