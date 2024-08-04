import java.util.*;
import java.io.*;


public class Main {
	public static int[][] a;
	public static int mSize;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		mSize = (int) Math.pow(2, n);
		a = new int[mSize][mSize];
		visited = new boolean[mSize][mSize];
		
		for(int i=0;i<mSize;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<mSize;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<q;i++) {
			int l = Integer.parseInt(st.nextToken());
			a = change(l);
			a = delMap();
		}

		
		int max = 0;
		int result = 0;
		for(int i=0;i<mSize;i++) {
			for(int j=0;j<mSize;j++) {
				if(!visited[i][j] && a[i][j] != 0) max = Math.max(max, findBig(i,j));
				result += a[i][j];
			}
		}
		System.out.println(result);
		System.out.println(max);
	}
	
	public static int[][] change(int l) { //회전을 위한 함수
		int lSize = (int) Math.pow(2, l);
		int[][] map = new int[mSize][mSize];
		
		for(int i=0;i<mSize;i+=lSize) { //사이즈의 크기 만큼
			for(int j=0;j<mSize;j+=lSize) {
				for(int x=0;x<lSize;x++) { //사이즈 안에서 회전
					for(int y=0;y<lSize;y++) {
						map[i+x][j+y] = a[i+lSize-y-1][j+x];
					}
				}
			}
		}
		return map;
	}
	
	public static int[][] delMap() { //삭제를 위한 함수
		int[][] map = new int[mSize][mSize];
		for(int i=0;i<mSize;i++) {
			map[i] = Arrays.copyOf(a[i], mSize);
		}

		for(int i=0;i<mSize;i++) {
			for(int j=0;j<mSize;j++) {
				if(bfs(i,j)) map[i][j] -= 1; //주변에 3개 이상의 얼음이 없으면 삭제
			}
		}
		return map;
	}
	
	public static boolean bfs(int x,int y) { //삭제할 때, 주변 4곳을 탐색할 함수
		int cnt =0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx<0 || nx>=mSize || ny<0 || ny>=mSize) continue;
			if(a[nx][ny] > 0) cnt++;
			//범위를 벗어나지 않고, 얼음이 존재하면 카운
		}
		if(cnt < 3 && a[x][y] > 0) return true;
		return false;
	}
	
	public static int findBig(int x,int y) { //가장 큰 얼음을 찾기 위한 함수
		visited[x][y] = true;
		int cnt = 1;
		Deque<int[]> dq = new ArrayDeque<>();
		dq.addLast(new int[] {x,y});
		
		while(!dq.isEmpty()) {
			int[] now = dq.pollFirst();
			for(int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx<0 || nx>=mSize || ny<0 || ny>=mSize) continue; //범위를 벗어나거나
				if(!visited[nx][ny] && a[nx][ny] != 0) { 
				//방문하지 않았고, 0이 아니면 계속해서 탐색
					visited[nx][ny] = true;
					cnt++;
					dq.addLast(new int[] {nx,ny});
				}
			}
		}
		
		return cnt;
	}
}
