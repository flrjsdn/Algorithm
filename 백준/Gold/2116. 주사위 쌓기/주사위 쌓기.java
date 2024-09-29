import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static int result, n;
	static int[][] arr;
	
	static void dfs(int start) {
		int sum = 0;
		int s = start;
		int e = nextIndex(s);
		sum += maxCal(arr[0][s],arr[0][e]);
		for(int i=1;i<n;i++) {
			for(int j=0;j<6;j++) {
				if(arr[i-1][e] == arr[i][j]) {
					s=j;
					break;
				}
			}
			e = nextIndex(s);
			sum += maxCal(arr[i][s],arr[i][e]);
		}
		result = Math.max(result, sum);
	}
	
	static int nextIndex(int before) {
		if(before==0) return 5;
		else if(before==1) return 3;
		else if(before==2) return 4;
		else if(before==3) return 1;
		else if(before==4) return 2;
		else return 0;
	}
	
	static int maxCal(int s, int e) {
		if(s ==6 || e == 6) {
			if(s == 5 || e == 5) return 4;
			else return 5;
		}else return 6;
	}
	
	public static void main(String[] args) throws Exception {
		n = read();
		arr = new int[n][6];
		for(int i=0;i<n;i++) {
			for(int j=0;j<6;j++) {
				arr[i][j] = read();
			}
		}
		
		for(int i=0;i<6;i++) {
			dfs(i);
		}
		System.out.println(result);
    }
}
