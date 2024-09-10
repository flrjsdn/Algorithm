import java.io.*;
import java.util.*;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int prev = 0;
		int now = 3;
		int mid = 3;
		
		while(n > now) {
			prev = now;
			now = now*2+(mid+1);
			mid++;
		}
		
		while(true) {
			if(prev < n && n <= prev + mid) {
				n -= prev;
				break;
			}
			if(n<=prev) {
				now = prev;
				mid--;
				prev = (now-mid) / 2;
			}else {
				now = prev;
				n -= (prev+mid);
				mid--;
				prev = (now-mid) / 2;
			}
		}
		if(n==1) System.out.println('m');
		else System.out.println('o');
    }
}
