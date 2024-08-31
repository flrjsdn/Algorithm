import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<s1.length();i++) {
			for(int j=0;j<s2.length();j++) {
				if(s1.charAt(i) == s2.charAt(j)) {
					dp[i+1][j+1] = dp[i][j] + 1;
				}
				else 
					dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}
		int x = s1.length();
		int y = s2.length();
		while(x!=0 && y !=0) {
			if(s1.charAt(x-1) == s2.charAt(y-1)) {
				sb.insert(0, s1.charAt(x-1));
				x -=1;
				y -= 1;
			}else if(dp[x-1][y] == dp[x][y]) {
				x-=1;
			}else if(dp[x][y-1] == dp[x][y]) {
				y -= 1;
			}
		}
		
		
		System.out.println(dp[s1.length()][s2.length()]);
		System.out.println(sb);
    }
}
