import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] dp = new int[n+1];
    	dp[1] = 1; //1은 상근, 2는 창영
    	if(n >= 2) {
    		dp[2] = 2;
    	}
    	for(int i=3;i<=n;i++) {
    		if(dp[i-1] == 1) {
    			dp[i] = 2;
    		}else if(dp[i-3] == 1) {
    			dp[i] = 2;
    		}
    		if(dp[i-1] == 2) {
    			dp[i] = 1;
    		}else if(dp[i-3] == 2){
    			dp[i] = 1;
    		}
    	}
    	String str = "SK";
    	if(dp[n] == 2) str = "CY";
    	System.out.println(str);
    }
}