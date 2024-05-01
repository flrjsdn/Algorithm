import java.util.*;
import java.io.*;

public class Main {
	public static int binarySearch(int[] arr, int target) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start+end) / 2;
			if(arr[mid] == target) return mid;
			if(arr[mid] > target) end = mid-1;
			else start = mid+1;
		}
		return -1;
		
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int n =sc.nextInt();
    	int[] arr = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		arr[i] = sc.nextInt();
    	}
    	
    	Arrays.sort(arr);
    	int m =sc.nextInt();
    	for(int i=0;i<m;i++) {
    		if(binarySearch(arr, sc.nextInt()) >= 0) {
    			System.out.println(1);
    		}else {
    			System.out.println(0);
    		}
    	}
    }
}