import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[][] arr = new int[n+1][2];
    	
    	for(int i=1;i<=n;i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		arr[i][0] = a; //시간
    		arr[i][1] = b; //비용
    	}
    	
    	int[] dp = new int[n+2];
    	dp[1] = 0;
    	for(int i=1;i<=n;i++) {
    		if(dp[i-1] > dp[i]) dp[i] = dp[i-1];
    		if((i+arr[i][0]) <= (n+1)) {
    			dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i] + arr[i][1]);
    		}
    	}
    	Arrays.sort(dp);
    	System.out.println(dp[n+1]);
    }
}