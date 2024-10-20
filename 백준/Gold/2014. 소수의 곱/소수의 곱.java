import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int k = read();
		int n = read();
		PriorityQueue<Long> pq = new PriorityQueue<>();
		HashSet<Long> set = new HashSet<>();
		long[] arr = new long[k];
		
		for(int i=0;i<k;i++) {
			Long num = Long.valueOf(read());
			arr[i] = num;
			pq.add(num);
		}
		
		for(int i=0;i<n-1;i++) {
			long now = pq.poll();
			
			for(int j=0;j<k;j++) {
				long next = now * arr[j];
				pq.add(next);
				if(now % arr[j] == 0) break; 
			}
		}
		System.out.println(pq.poll());
    }
}
