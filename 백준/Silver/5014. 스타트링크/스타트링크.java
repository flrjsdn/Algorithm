
import java.util.*;
public class Main {
	public static int f,s,g,u,d;
	
	public static String bfs(int floor, int start, int end, int up, int down, int[] arr) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		arr[start] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == end) {
				return String.valueOf(arr[now]-1);
			}
			if(now + up <= floor) {
				if(arr[now+up] == 0) {
					arr[now+up] = arr[now] + 1;
					q.add(now+up);
				}
			}
			if(now-down > 0) {
				if(arr[now-down] == 0) {
					arr[now-down] = arr[now] + 1;
					q.add(now-down);
				}
			}
		}
		return "use the stairs";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		int[] arr = new int[f+1];
		System.out.println(bfs(f,s,g,u,d,arr));
	}
}
