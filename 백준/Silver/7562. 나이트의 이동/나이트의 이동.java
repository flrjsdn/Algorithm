
import java.util.*;
public class Main {
	public static int l,sx,sy,fx,fy;
	public static int[][] map;
	public static int[] dx = {-2,-1,2,1,-2,-1,2,1};
	public static int[] dy = {-1,-2,-1,-2,1,2,1,2};
	
	public static void bfs(int x,int y) {
		Queue<int[]> q = new LinkedList<>();
		map[x][y] = 1;
		q.offer(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0;i<8;i++) {
				int nx = nowX + dx[i];
				int ny = nowY + dy[i];
				if(nx == fx && ny == fy) {
					System.out.println(map[nowX][nowY]);
					return;
				}
				if(nx>=0 && nx<l && ny>=0 && ny<l && map[nx][ny] == 0) {
					map[nx][ny] = map[nowX][nowY] + 1;
					q.offer(new int[] {nx,ny});
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for(int tc=1; tc<=testCase; tc++) {
			l = sc.nextInt();
			sx = sc.nextInt();
			sy = sc.nextInt();
			fx = sc.nextInt();
			fy = sc.nextInt();
			map = new int[l][l];
			if(sx == fx && sy == fy) System.out.println(0);
			else bfs(sx,sy);
		}
	}
}
