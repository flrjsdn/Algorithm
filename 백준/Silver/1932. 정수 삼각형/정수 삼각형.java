import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
    	int[][] map = new int[n][n];
    	int[][] dp = new int[n][n];
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<i+1;j++) {
    			map[i][j] = sc.nextInt();
    			dp[i][j] = map[i][j];
    		}
    	}
    	
    	for(int i=1;i<n;i++) {
    		int leftUp, Up;
    		for(int j=0;j<i+1;j++) {
    			if(j==0) leftUp = 0;
    			else leftUp = dp[i-1][j-1];
    			
    			if(j==i) Up = 0;
    			else Up = dp[i-1][j];
    			dp[i][j] += Math.max(leftUp, Up);
    		}
    	}
    	int result = 0;
    	for(int i=0;i<n;i++) {
    		result = Math.max(result, dp[n-1][i]);
    	}
    	System.out.println(result);
    }
}