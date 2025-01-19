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
		int t;
		int c;
		int cPrice;
		
		public Node(int t, int c,int cPrice) {
			this.t = t;
			this.c = c;
			this.cPrice = cPrice;
		}
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		
		int[] streetCount = new int[n-1];
		int start = read();
		for(int i=0;i<m-1;i++) {
			int next = read();
			if(start < next) {
				for(int j=start;j<next;j++) {
					streetCount[j-1]++;
				}
			}else {
				for(int j=start-1;j>=next;j--) {
					streetCount[j-1]++;
				}
			}
			start = next;
		}
		
		ArrayList<Node> arr = new ArrayList<>();
		for(int i=0;i<n-1;i++) {
			int a = read();
			int b = read();
			int c = read();
			arr.add(new Node(a,b,c));
		}
		int sum = 0;
		for(int i=0;i<n-1;i++) {
			int tSum = streetCount[i] * arr.get(i).t;
			int cSum = streetCount[i] * arr.get(i).c + arr.get(i).cPrice;
			if(tSum > cSum) sum += cSum;
			else sum += tSum;
		}
		System.out.println(sum);
    }
}
