import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	long[] dp = new long[41];
    	
    	dp[0] = 1;
    	dp[1] = 1;
    	dp[2] = 2;
    	for(int i=3;i<=n;i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	
    	long result = 1;
    	int before = 0;
    	for(int i=0;i<m;i++) {
    		int x = sc.nextInt();
    		result *= dp[x-before-1];
    		before = x;
    	}
    	result *= dp[n-before];
    	
    	
    	System.out.println(result);
    }
}