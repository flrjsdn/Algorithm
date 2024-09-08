import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static char[][] result;
	
	static void dfs(int depth, int start, int end) {
		if(depth == 7) return;
		
		int mid = (start+end) / 2;
		
		for(int i=start;i<mid;i++) {
			result[depth][i] = 'A';
		}
		for(int i=mid;i<end;i++) {
			result[depth][i] = 'B';
		}
		
		dfs(depth+1, start, mid);
		dfs(depth+1, mid, end);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		result = new char[7][n];
		
		
		dfs(0,0,n);
		
		for(int i=0;i<7;i++) {
			if(!Arrays.asList(result[i]).contains('A')) {
				result[i][0] = 'A';
			}
			for(int j=0;j<n;j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
    }
}
