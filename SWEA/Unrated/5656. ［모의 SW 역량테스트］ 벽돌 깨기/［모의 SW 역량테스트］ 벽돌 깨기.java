import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws IOException {
    	if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Integer.parseInt(st.nextToken());
    }
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int w,h, n;
    static int[][] map;
    static boolean[][] visited;
    static int result;
    
    static void dfs(int depth, int[] arr) {
    	if(depth == n) {
    		result = Math.min(result, play(arr));
    		return;
    	}
    	
    	for(int i=0;i<w;i++) {
    		arr[depth] = i;
    		dfs(depth+1, arr);
    	}
    }
    
    static int play(int[] arr) {
    	int[][] newMap = new int[h][w];
    	for(int i=0;i<h;i++) {
    		newMap[i] = Arrays.copyOf(map[i], w);
    	}
    	for(int i=0;i<arr.length;i++) {
    		for(int j=0;j<h;j++) {
    			if(newMap[j][arr[i]] != 0) {
    				visited = new boolean[h][w];
    				bomb(j,arr[i], newMap);
    				down(newMap);
//    				printMap(newMap);
    				break;
    			}
    		}
    	}
    	
    	int ans = 0;
    	for(int i=0;i<h;i++) {
    		for(int j=0;j<w;j++) {
    			if(newMap[i][j] != 0) ans++;
    		}
    	}
    	return ans;
    }
    
    static void down(int[][] newMap) {
    	for(int i=0;i<w;i++) {
    		for(int j=h-2;j>=0;j--) {
    			if(newMap[j][i] != 0 && newMap[j+1][i] == 0) {
    				int height = j+1;
    				while(height<h && newMap[height][i] == 0) height++;
    				newMap[height-1][i] = newMap[j][i];
    				newMap[j][i] = 0;
    			}
    		}
    	}
    }
    
    static void bomb(int x,int y, int[][] newMap) {
    	visited[x][y] = true;
    	int nx = x;
    	int ny = y;
    	for(int i=1;i<newMap[x][y];i++) {
    		for(int j=0;j<4;j++) {
    			nx = x + dx[j]*i;
    			ny = y + dy[j]*i;
    			if(nx<0 || nx>= h || ny<0 || ny>=w) continue;
    			if(!visited[nx][ny]) {
    				bomb(nx,ny, newMap);
    			}
    		}
    	}
    	newMap[x][y] = 0;
    }
    
    static void printMap(int[][] map) {
    	for(int i=0;i<h;i++) {
    		for(int j=0;j<w;j++) {
    			System.out.print(map[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    public static void main(String[] args) throws IOException {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for(int tc=1;tc<=T;tc++) {
        	n = read();
        	w = read();
        	h = read();
        	map = new int[h][w];
        	for(int i=0;i<h;i++) {
        		for(int j=0;j<w;j++) {
        			map[i][j] = read();
        		}
        	}
        	int[] arr = new int[n];
        	result = Integer.MAX_VALUE;
        	dfs(0, arr);
        	sb.append("#"+tc+" " + result +"\n");
        }
        System.out.println(sb);
    }
}