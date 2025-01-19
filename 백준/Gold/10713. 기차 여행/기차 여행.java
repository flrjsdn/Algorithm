import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	

	static class Node {
		long t;
		long c;
		long cPrice;
		
		public Node(long t, long c,long cPrice) {
			this.t = t;
			this.c = c;
			this.cPrice = cPrice;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		
		int[] streetCount = new int[n];
		int[] streets = new int[m];
		for(int i=0;i<m;i++) {
			streets[i] = read();
		}
		for(int i=1;i<m;i++) {
			int start = streets[i-1];
			int next = streets[i];
			
			if(start > next) {
				int tmp = start;
				start = next;
				next = tmp;
			}
			streetCount[start-1]++;
			streetCount[next-1]--;
		}
		
		ArrayList<Node> arr = new ArrayList<>();
		for(int i=0;i<n-1;i++) {
			int a = read();
			int b = read();
			int c = read();
			arr.add(new Node(a,b,c));
		}
		long sum = 0;
		long pSum = 0;
		for(int i=0;i<n-1;i++) {
			pSum += streetCount[i];
			long tSum = pSum * arr.get(i).t;
			long cSum = pSum * arr.get(i).c + arr.get(i).cPrice;
			sum += Math.min(tSum, cSum);
		}
		System.out.println(sum);
    }
}
