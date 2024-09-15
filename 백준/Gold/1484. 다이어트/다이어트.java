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
		int g = read();
		int start = 1;
		int end = 1;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		while(true) {
			long diff = (long)Math.pow(start, 2) - (long)Math.pow(end, 2);
			if(start - end == 1 && diff > g) break;
			if(diff >= g) end++;
			else start++;
			
			if(diff==g) {
				sb.append(start + "\n");
				flag = true;
			}
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(sb);
    }
}
