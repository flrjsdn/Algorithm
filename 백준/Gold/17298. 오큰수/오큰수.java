import java.util.*;
import java.io.*;


class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i=0;i<n;i++) {
			while(!stack.isEmpty() && a[stack.peekLast()] < a[i]) {
				a[stack.pollLast()] = a[i];
			}
			stack.add(i);
		}
		
		while(!stack.isEmpty()) {
			a[stack.pollLast()] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(a[i]+ " ");
		}
		System.out.println(sb);
	}
}