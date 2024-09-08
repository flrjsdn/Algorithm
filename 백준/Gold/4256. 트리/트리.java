import java.io.*;
import java.util.*;


public class Main {
	static int n;
	static int[] preOrder, inOrder;
	static StringBuilder sb;
	static void findPostOrder(int root, int begin, int end) {
		if(root>=n) return;
		
		int rootValue = preOrder[root];
		
		for(int i=begin;i<=end;i++) {
			if(rootValue == inOrder[i]) {
				findPostOrder(root+1, begin, i); //왼쪽 탐색
				findPostOrder(root+(i-begin) + 1, i+1, end); //왼쪽 자식 수 빼주기
				sb.append(rootValue + " ");
				return;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			preOrder = new int[n];
			inOrder = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				preOrder[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				inOrder[i] = Integer.parseInt(st.nextToken());
			}
			findPostOrder(0, 0, n-1);
			sb.append("\n");
		}
		System.out.println(sb);
    }
}
