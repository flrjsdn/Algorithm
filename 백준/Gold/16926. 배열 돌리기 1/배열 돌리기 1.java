import java.io.*;
import java.util.*;


public class Main {
	public static int n,m;

	
	public static int[][] change(int[][] map) {
		int[][] newMap = new int[n][m];
		for(int i=0;i<n;i++) {
			newMap[i] = Arrays.copyOf(map[i], m);
		}
		int count = Math.min(n, m) / 2;
		for(int i=0;i<count;i++) {
			for(int j=i;j<m-i-1;j++) {
				newMap[i][j] = map[i][j+1];
			}
			for(int j=i;j<n-i-1;j++) {
				newMap[j][m-i-1] = map[j+1][m-i-1];
			}
			for(int j=m-i-1;j>=i+1;j--) {
				newMap[n-i-1][j] = map[n-i-1][j-1];
			}
			for(int j=n-i-1;j>=i+1;j--) {
				newMap[j][i] = map[j-1][i];
			}
		}
		return newMap;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] result;
		for(int i=0;i<r;i++) {
			result = change(map);
			map = result;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
    }
}
