import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	long[] arr = new long[n];
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	while(m != 0) {
    		m -= 1;
    		Arrays.sort(arr);
    		long sum = arr[0] + arr[1];
    		arr[0] = sum;
    		arr[1] = sum;
    	}
    	long result = 0;
    	for(int i=0;i<n;i++) {
    		result += arr[i];
    	}
    	System.out.println(result);
    }
}