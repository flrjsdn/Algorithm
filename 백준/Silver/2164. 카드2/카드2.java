import java.util.*;
import java.io.*;


class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		
		if(q.size()==1) {
			System.out.println(q.poll());
			return;
		}
		while(true) {
			q.poll();
			if(q.size() == 1) {
				System.out.println(q.poll());
				return;
			}
			int now = q.poll();
			q.add(now);
		}
	}
}