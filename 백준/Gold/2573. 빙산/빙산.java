import java.util.*;
import java.io.*;

public class Main {
	public static int n,m;
	public static int[][] map;
	public static int[][] cntMap;
	public static boolean[][] visited;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void dfs(int x,int y) { //덩어리 확인을 위한 함수
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(!visited[nx][ny] && map[nx][ny] != 0) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void bfs(int x, int y) { //주변 0 세기
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(map[nx][ny] == 0) {
				cnt++;
			}
		}
		cntMap[x][y] = cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		cntMap = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int result = 0;
		while(true) {
			visited = new boolean[n][m];
			int cnt = 0;
			boolean check = false;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(map[i][j] != 0 && !visited[i][j]) {
						cnt++;
						check = true;
						dfs(i,j);
					}
				}
			}
			if(cnt >= 2) {
				break;
			}
			if(!check) {
				result = 0;
				break;
			}
			
			for(int i=0;i<n;i++) {// 주변 0 세기
				for(int j=0;j<m;j++) {
					if(map[i][j] != 0) bfs(i,j);
				}
			}
			for(int i=0;i<n;i++) { //1년 지남
				for(int j=0;j<m;j++) {
					if((map[i][j] - cntMap[i][j]) < 0) {
						map[i][j] = 0;
					}else {
						map[i][j] -= cntMap[i][j];
					}
				}
			}
			result++;
		}
		System.out.println(result);
	}
}