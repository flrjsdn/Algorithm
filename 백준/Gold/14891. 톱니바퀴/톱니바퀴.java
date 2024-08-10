import java.io.*;
import java.util.*;


public class Main {
	public static String[] sList;
	public static boolean[] change;
	
	public static void findChange() {
		for(int i=1;i<4;i++) {
			if(sList[i].charAt(2) != sList[i+1].charAt(6)) {
				change[i] = true;
			}else {
				change[i] = false;
			}
		}
	}
	
	public static void rotate(int index, int r) {
		String s;
		if(r == -1) {
			s = sList[index].substring(1) + sList[index].substring(0,1);
		}else {
			s = sList[index].substring(7) + sList[index].substring(0,7);
		}
		sList[index] = s;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sList = new String[5];
		change = new boolean[4];
		
		for(int i=1;i<=4;i++) {
			sList[i] = br.readLine();
		}
		findChange();

		
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int nextR = r;
			rotate(n,nextR);
			
			for(int j=n-1;j>=1;j--) {
				nextR *= -1;
				if(change[j]) {
					rotate(j, nextR);
				}else {
					break;
				}
			}
			
			nextR = r;
			for(int j=n+1;j<=4;j++) {
				nextR *= -1;
				if(change[j-1]) {
					rotate(j, nextR);
				}else {
					break;
				}
			}
			findChange();
		}
		int result = 0;
		int d = 1;
		for(int j=1;j<=4;j++) {
			if(sList[j].charAt(0)== '1') {
				result += d;
			}
			d*= 2;
		}
		System.out.println(result);
    }
}
