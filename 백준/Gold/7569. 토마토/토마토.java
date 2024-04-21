
import java.util.*;
public class Main {
	public static int m, n, h;
	public static int[][][] map;
	public static int[][][] nextMap;
	public static int[] dx = {1,-1,0,0,0,0};
	public static int[] dy = {0,0,1,-1,0,0};
	public static int[] dz = {0,0,0,0,1,-1};
	public static Queue<int[]> q = new LinkedList<>();
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowZ = now[0];
			int nowX = now[1];
			int nowY = now[2];
			for(int i=0;i<6;i++) {
				int nz = nowZ+dz[i];
				int nx = nowX+dx[i];
				int ny = nowY+dy[i];
				if(nz >= 0 && nz < h && nx>=0 && nx<n && ny>=0 && ny<m) {
					if(nextMap[nz][nx][ny] == 0) {
						nextMap[nz][nx][ny] = nextMap[nowZ][nowX][nowY] + 1;
						q.offer(new int[] {nz,nx,ny});
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		map = new int[h][n][m];
		nextMap = new int[h][n][m];
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					map[k][i][j] = sc.nextInt();
					nextMap[k][i][j] = map[k][i][j];
					if(map[k][i][j] == 1) {
						q.offer(new int[] {k,i,j});
					}
				}
			}
		}
		bfs();
		int result = 0;
		boolean check = true;
		for(int k=0;k<h;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(nextMap[k][i][j] == 0) {
						check = false;
						break;
					}
					if(nextMap[k][i][j] > result) result = nextMap[k][i][j];
				}
			}
		}
		if(check) System.out.println(result-1);
		else System.out.println(-1);
	}
}
