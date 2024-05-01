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
class Node implements Comparable<Node> {
	private int x;
	private int y;
	private int time;
	
	public Node(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public int getTime() {
		return this.time;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.time, other.time);
	}
}
class Solution
{
    public static int n;
	public static int min;
	public static int[][] map;
	public static boolean[][] visited;
	
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	
	public static void bfs(int x, int y, int time) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,y,time));
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			for(int i=0;i<4;i++) {
				int nx = now.getX() + dx[i];
				int ny = now.getY() + dy[i];
				int ntime = now.getTime();
				if(nx == n-1 && ny == n-1) {
					min = Math.min(min, ntime + map[nx][ny]);
					return;
				}
				if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				pq.offer(new Node(nx,ny, ntime+map[nx][ny]));
			}
		}
	}
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
    	for(int tc=1;tc<=T;tc++) {
    		n = sc.nextInt();
    		map = new int[n][n];
    		visited = new boolean[n][n];
    		min = Integer.MAX_VALUE;
            
    		for(int i=0;i<n;i++) {
    			String str = sc.next();
    			for(int j=0;j<n;j++) {
    				map[i][j] = str.charAt(j) - '0';
    			}
    		}
    		
    		bfs(0,0,0);
    		System.out.println("#" + tc + " " + min);
    	}
	}
}