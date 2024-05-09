import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1;tc<=T;tc++) {
    		int n = sc.nextInt();
    		long[] dp = new long[n+1];
    		dp[1] = 1;
    		if(n >= 2) {
    			dp[2] = 1;
    		}
    		
    		for(int i=3;i<=n;i++) {
    			dp[i] = dp[i-2] + dp[i-3];
    		}
    		
    		System.out.println(dp[n]);
    	}
    }
}