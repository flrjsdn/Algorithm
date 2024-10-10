import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	static final int INF = (int)1e9;
	
	public static void main(String[] args) throws Exception {
		int T = read();
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int n = read();
			int x = read();
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j] = read();
				}
			}
			int ans = 0;
			for(int i=0;i<n;i++) {
				boolean can = true;
				int cnt = 1;
				for(int j=1;j<n;j++) {
					//행 기준
					if(Math.abs(map[i][j] - map[i][j-1]) > 1) {
						can = false;
						break;
					}
					if(map[i][j] > map[i][j-1]) { //현재보다 작으면
						if(cnt >= x) { //전에 개수가 x보다 크거나 같으면 이어질 수 있음
							cnt = 1;
						}else { //아닐 시 불가능
							can = false;
							break;
						}
					}else if(map[i][j] < map[i][j-1]) { //현재보다 전에가 더 크면
						if(!can) {
							break;
						}
						can = false; //우선 불가능이라 만든 다음
						cnt = 1; //cnt를 보기
					}else if(map[i][j] == map[i][j-1]){ //같은 경우
						cnt++; //갯수 증가
						if(!can && cnt>=x) { //만약 false인데 갯수가 x가 되면
							can = true;
							cnt = 0;
						}
					}
				}
				if(can) {
//					System.out.println(i);
					ans++;
				}
				
				can = true;
				cnt = 1;
				for(int j=1;j<n;j++) {
					//열 기준
					if(Math.abs(map[j][i] - map[j-1][i]) > 1) {
						can = false;
						break;
					}
					if(map[j][i] > map[j-1][i]) { //현재보다 작으면
						if(cnt >= x) { //전에 개수가 x보다 크거나 같으면 이어질 수 있음
							cnt = 1;
						}else { //아닐 시 불가능
							can = false;
							break;
						}
					}else if(map[j][i] < map[j-1][i]) { //현재보다 전에가 더 크면
						if(!can) {
							break;
						}
						can = false; //우선 불가능이라 만든 다음
						cnt = 1; //cnt를 보기
					}else if(map[j][i] == map[j-1][i]){ //같은 경우
						cnt++; //갯수 증가
						if(!can && cnt>=x) { //만약 false인데 갯수가 x가 되면
							can = true;
							cnt = 0;
						}
					}
				}
				if(can) {
					//System.out.println(i);
					ans++;
				}
				
			}
			sb.append("#"+tc+" " + ans+"\n");
		}
		System.out.println(sb);
	}
}