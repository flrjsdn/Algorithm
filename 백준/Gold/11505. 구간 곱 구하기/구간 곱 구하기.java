import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	static long segmentTree[];
	static long[] arr;
	static final int MOD = 1_000_000_007;
	
	static long init(int start, int end, int node) {
		if(start == end) {
			segmentTree[node] = arr[start];
			return arr[start];
		}
		
		int mid = (start + end) / 2;
		long rightNode = init(start, mid, node * 2) % MOD;
		long leftNode = init(mid+1, end, node * 2 + 1) % MOD;
		segmentTree[node] = (leftNode * rightNode) % MOD;
		return segmentTree[node];
	}
	
	static void rangeUpdate(int targetStart, int targetEnd, int start, int end, int addNode, int node) {
		
		if(start == targetStart && end == targetEnd) {
			segmentTree[node] = addNode;
			arr[start] = addNode;
			return;
		}
		
		if(start > targetEnd || end < targetStart) {
			return;
		}
		
		int mid = (start + end) / 2;
		rangeUpdate(targetStart, targetEnd, start, mid, addNode, node * 2);
		rangeUpdate(targetStart, targetEnd, mid+1, end, addNode, node * 2 + 1);
		segmentTree[node] = (segmentTree[node * 2] * segmentTree[node * 2 + 1]) % MOD;
	}
	
	static long rangeQuery(int targetStart, int targetEnd, int start, int end, int node) {
		if(start >= targetStart && end <= targetEnd) {
			return segmentTree[node];
		}
		
		if(start > targetEnd || end < targetStart) {
			return 1;
		}
		
		int mid = (start + end) / 2;
		long sum = 0;
		long leftNode = rangeQuery(targetStart, targetEnd, start, mid, node * 2);
		long rightNode = rangeQuery(targetStart, targetEnd, mid + 1, end, node* 2 + 1);
		sum = (leftNode * rightNode) % MOD;
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		int k = read();
		segmentTree = new long[4*n];
		arr = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = read();
		}
		
		init(0, arr.length-1, 1);
		for(int i=0;i<m+k;i++) {
			int a = read();
			int b = read();
			int c = read();
			if(a == 1) {
				rangeUpdate(b-1, b-1, 0, arr.length-1, c, 1);
			} else if(a==2) {
				System.out.println(rangeQuery(b-1,c-1, 0, arr.length-1, 1) % MOD);
			}
		}
    }
}
