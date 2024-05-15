import java.util.*;
import java.io.*;

public class Main {
	public static int n,m;
	public static int[] arr;
	public static int result;
	public static void binarySearch() {
		int start = 0;
		int end = arr[arr.length-1];
		
		while(start <= end) {
			int mid = (start+end) / 2;
			int sum = 0;
			for(int i=0;i<n;i++) {
				if(arr[i] >= mid) sum += mid;
				else sum += arr[i];
			}
			if(sum > m) end = mid - 1;
			else {
				result = Math.max(result, mid);
				start = mid + 1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		m = sc.nextInt();
		binarySearch();
		System.out.println(result);
	}
}