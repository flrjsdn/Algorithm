import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static int[] makeTable(String s) {
		int pLen = s.length();
		int[] table = new int[pLen];
		char[] pList = s.toCharArray();
		int idx = 0;
		for(int i=1;i<pLen;i++) {
			while(idx > 0 && pList[i] != pList[idx]) {
				idx = table[idx-1];
			}
			if(pList[i] == pList[idx]) {
				idx++;
			}
			table[i] = idx;
		}
		return table;
	}
	
	static int[] table;
	
	public static void main(String[] args) throws Exception {
		int l = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		table = makeTable(s);
		System.out.println(l - table[l-1]);
    }
}
