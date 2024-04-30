import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n = sc.nextInt();
    	int[] arr = new int[n];
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr);
    	int[] result = new int[n];
    	int index = n;
    	for(int i=0;i<n;i++) {
    		result[i] = index*arr[i];
    		index--;
    	}
    	
    	Arrays.sort(result);
    	System.out.println(result[n-1]);
    }
}
