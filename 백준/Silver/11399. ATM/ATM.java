import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}				
		Arrays.sort(arr);
		dp[0] = arr[0];
		for(int i=1;i<n;i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		int result = 0;
		for(int i=0;i<n;i++) {
			result += dp[i];
		}
		
		System.out.println(result);
	}
}
