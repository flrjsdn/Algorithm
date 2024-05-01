import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
    	int m = sc.nextInt();
    	int[] arr = new int[n];
    	
    	int[] dp = new int[n+1];
    	
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt(); 
    	}
    	
    	for(int i=1;i<=n;i++) {
    		dp[i] = (dp[i-1] + arr[i-1]);
    	}
    	
    	for(int i=0;i<m;i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		int result = dp[b] - dp[a-1];
    		System.out.println(result);
    	}
    	
    }
}
