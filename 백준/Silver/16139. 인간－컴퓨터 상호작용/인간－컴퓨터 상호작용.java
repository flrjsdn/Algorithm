import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int length = s.length();
		int[][] arr = new int[26][length+1];
		int c = s.charAt(0) - 'a';

		
		for(int i=1;i<=length;i++) {
			int x = s.charAt(i-1) - 'a';
			arr[x][i] += 1;
			for(int j=0;j<26;j++) {
				arr[j][i] += arr[j][i-1];
			}
		}

		
		int q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int i=0;i<q;i++) {
			st = new StringTokenizer(br.readLine());
			int x = st.nextToken().charAt(0) - 'a';
			int a = Integer.parseInt(st.nextToken())+1;
			int b = Integer.parseInt(st.nextToken())+1;
			
			sb.append(arr[x][b] - arr[x][a-1]).append("\n");
		}
		System.out.println(sb);
    }
}
