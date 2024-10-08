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
		int n = Integer.parseInt(br.readLine());
		String[] sList = new String[n];
		for(int i=0;i<n;i++) {
			sList[i] = br.readLine();
		}
		
		String s1 = "";
		String s2 = "";
		int cnt = 0;
		
		for(int i=0;i<n;i++) {
			if(sList[i].length() < cnt) continue;
			for(int j=i+1;j<n;j++) {
				if(sList[j].length() < cnt) continue;
				int min = Math.min(sList[i].length(), sList[j].length());
				
				int c = 0;
				for(int k=0;k<min;k++) {
					if(sList[i].charAt(k) == sList[j].charAt(k)) {
						c++;
					}else break;
				}
				
				 if(c > cnt) {
					 cnt = c;
					 s1 = sList[i];
					 s2 = sList[j];
				 }
			}
		}
		
		System.out.println(s1 + "\n" + s2);
	}
}