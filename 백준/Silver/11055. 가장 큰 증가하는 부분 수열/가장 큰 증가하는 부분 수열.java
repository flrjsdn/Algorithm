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
    		dp[i] = arr[i];
    	}
    	
    	for(int i=1;i<n;i++) {
    		for(int j=0;j<i;j++) {
    			if(arr[i] > arr[j]) {
    				dp[i] = Math.max(dp[j] + arr[i], dp[i]);
    			}
    		}
    	}
    	
    	Arrays.sort(dp);
    	System.out.println(dp[n-1]);
    }
}