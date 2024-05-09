import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	int[] dp = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.fill(dp, 1);
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(arr[j] < arr[i]) {
        			dp[i] = Math.max(dp[i], dp[j] + 1);
        		}
    		}
    	}
    	Arrays.sort(dp);
    	System.out.println(dp[n-1]);
    }
}