import java.util.*;
import java.io.*;


class Main {
	public static int n;
	public static int[][] origin;
	
	public static int[][] recur(int[][] arr, long b) {
		if(b == 1L) {
			return arr;
		}
		
		int[][] temp = recur(arr, b /2);
		
		temp = multi(temp,temp);
		
		if(b % 2 == 1L) {
			temp = multi(temp, origin);
		}
		
		return temp;
	}
	
	public static int[][] multi(int[][] a, int[][] b) {
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					arr[i][j] += a[i][k] * b[k][j];
					arr[i][j] %= 1000;
				}
			}
		}
		return arr;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		StringBuilder sb = new StringBuilder();
		origin = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				origin[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] result = recur(origin,b);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}