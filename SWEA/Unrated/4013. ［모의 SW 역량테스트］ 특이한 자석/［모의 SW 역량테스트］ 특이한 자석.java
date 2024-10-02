import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static int[][] sList;
	public static boolean[] change;
	
	public static void findChange() {
		for(int i=1;i<4;i++) {
			if(sList[i][2] != sList[i+1][6]) {
				change[i] = true;
			}else {
				change[i] = false;
			}
		}
	}
	
	public static void rotate(int index, int r) {

		if(r == -1) {
			int temp = sList[index][0];
			for(int i=0;i<7;i++) {
				sList[index][i] = sList[index][i+1];
			}
			sList[index][7] = temp;
		}else {
			int temp = sList[index][7];
			for(int i=7;i>=1;i--) {
				sList[index][i] = sList[index][i-1];
			}
			sList[index][0] = temp;
		}
	}
	
	public static void main(String[] args) throws Exception {
		change = new boolean[4];
		int T = read();
		StringBuilder sb = new StringBuilder();
		sList = new int[5][8];
		for(int tc=1;tc<=T;tc++) {
			int k = read();
			for(int i=1;i<=4;i++) {
				for(int j=0;j<8;j++) {
					sList[i][j] = read();
				}
			}
			
			
			for(int c=0;c<k;c++) {
				int num = read();
				int d = read();
				findChange();
				rotate(num, d);
				int changeD = d;
				
				for(int i=num-1;i>=1;i--) {
					changeD *= -1;
					if(change[i]) {
						rotate(i,changeD);
					} else break;
				}
				
				changeD = d;
				for(int i=num+1;i<=4;i++) {
					changeD *= -1;
					if(change[i-1]) {
						rotate(i,changeD);
					}else break;
				}
				
			}
			
			int result = 0;
			for(int i=1;i<=4;i++) {
				if(sList[i][0] == 1) result += Math.pow(2, i-1); 
			}
			sb.append("#"+tc+" " + result + "\n");
		}
		System.out.println(sb);
	}
}