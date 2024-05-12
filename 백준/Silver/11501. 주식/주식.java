import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			long result = 0;
			int beforeNum = arr[arr.length-1];
			for(int i=arr.length-2;i>=0;i--) {
				if(arr[i] > beforeNum) {
					beforeNum = arr[i];
				}else {
					result += (beforeNum - arr[i]);
				}
			}
			System.out.println(result);
		}
	}
}
