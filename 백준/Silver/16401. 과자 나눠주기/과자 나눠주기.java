import java.util.*;

public class Main {
	public static int max = 0;
	public static void binarySearch(int[] arr, int target) {
		int start = 1;
		int end = arr[arr.length-1];
		int cnt = 0;
		
		while(start <= end) {
			cnt = 0;
			int mid = (start + end) / 2;
			for(int i=0;i<arr.length;i++) {
				cnt += (arr[i] / mid);
			}
			if(cnt >= target) {
				max = Math.max(max, mid);
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		binarySearch(arr, m);
		System.out.println(max);
	}
}