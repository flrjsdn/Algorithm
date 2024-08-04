import java.io.*;
import java.util.*;

public class Main {
	public static boolean binarySearch(int x, int[] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start<=end) {
			int mid = (start+end) / 2;
			if(arr[mid] == x) return true;
			else if(arr[mid] > x) end = mid-1;
			else start = mid+1;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		int[] aList = new int[a];
		int[] bList = new int[b];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) {
			aList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(aList);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			bList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bList);
		
		for(Integer n : aList) {
			if(!binarySearch(n, bList)) {
				sb.append(n).append(" ");
				cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println(0);
		}else {
			System.out.println(cnt);
			System.out.println(sb);
		}
    }
}
