/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static int n;
	public static int[][] map;
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static int result, index;
	
	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		
		int cnt = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
				if(map[nx][ny] == (map[now[0]][now[1]] + 1)) {
					cnt++;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		if(cnt > result) {
			result = cnt;
			index = map[x][y];
		}else if(cnt == result) {
            index = Math.min(index, map[x][y]);
        }
	}
	
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for(int tc=1;tc<=T;tc++) {
    		n =sc.nextInt();
    		map = new int[n][n];
    		result = 0;
    		index = Integer.MAX_VALUE;
    		
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				map[i][j] = sc.nextInt();
    			}
    		}
    		
    		for(int i=0;i<n;i++) {
    			for(int j=0;j<n;j++) {
    				bfs(i,j);
    			}
    		}
    		System.out.println("#" + tc + " " + index + " " + result);
    	}
    }
}