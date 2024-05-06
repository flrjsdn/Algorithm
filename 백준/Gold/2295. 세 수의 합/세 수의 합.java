import java.util.*;
import java.io.*;

public class Main {
	public static ArrayList<Integer> arr;
	public static int n;
	public static int max = 0;
	public static int[] map;
	
	public static boolean search(int n) {
		int s = 0;
		int e = arr.size()-1;
		while(s <= e) {
			int mid = (s+e) /2;
			if(arr.get(mid) == n) {
				return true;
			}
			if(arr.get(mid) > n) {
				e = mid-1;
			}
			else {
				s = mid + 1;
			}
		}
		return false;
	}
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	n = sc.nextInt();
    	arr = new ArrayList<>();
    	map = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		map[i] = sc.nextInt();
    	}
    	for(int i=0;i<n;i++) {
    		for(int j=i;j<n;j++) {
    			arr.add(map[i] + map[j]);
    		}
    	}
    	
    	Arrays.sort(map);
    	Collections.sort(arr);
    	
    	for(int i=n-1;i>=0;i--) {
    		for(int j=0;j<i;j++) {
    			int gap = map[i] - map[j];
    			if(search(gap) && map[i] > max) {
    				max = map[i];
    			}
    		}
    	}
    	System.out.println(max);
    }
}