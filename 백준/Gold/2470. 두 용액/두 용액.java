import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int n =read();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = read();
		}
		
		Arrays.sort(arr);
		int start = 0;
		int end = n-1;
		int result = Integer.MAX_VALUE;
		int x = -1;
		int y = -1;
		
		while(start < end) {
			int sum = arr[end] + arr[start];

			if(result > Math.abs(sum)) {
				x = start;
				y = end;
				result = Math.abs(sum);
			}
			
			if(sum > 0) end--;
			else start++;
		}
		System.out.println(arr[x] + " " + arr[y]);
    }
}
