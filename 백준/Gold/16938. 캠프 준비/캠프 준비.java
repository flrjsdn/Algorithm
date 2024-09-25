import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	
	public static void main(String[] args) throws Exception{
		int n = read();
		int l = read();
		int r = read();
		int x = read();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = read();
		}
		
		int result = 0;
		for(int i=1;i<(1<<n);i++) {
			if(Integer.bitCount(i) < 2) continue;
			long hap = 0;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for(int j=0;j<n;j++) {
				if((i & (1<<j)) != 0) {
					hap += arr[j];
					min = Math.min(min, arr[j]);
					max = Math.max(max, arr[j]);
				}
			}
			
			if(hap >= l && hap <= r && (max-min) >= x) result++;
		}
		System.out.println(result);
	}
}
