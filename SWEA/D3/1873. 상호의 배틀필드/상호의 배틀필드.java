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

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int h,w,n,x,y;
	public static char[][] map;
	public static char[][] nextMap;
	public static char[] arr = {'U', 'D', 'L', 'R'};
	public static char[] directions = {'^', 'v', '<', '>'};
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	
	public static void dfs(char c) {
		for(int i=0;i<4;i++) {
			if(c == arr[i]) {
				int nx = x + dx[i];
				int ny = y + dy[i];
                nextMap[x][y] = directions[i];
				if(nx>=0 && nx<h && ny>=0 && ny<w) {
					if(nextMap[nx][ny] == '.') {
						nextMap[x][y] = '.';
						nextMap[nx][ny] = directions[i];
						x = nx;
						y = ny;
					}else {
						nextMap[x][y] = directions[i];
					}
				}
			}
		}
		if(c == 'S') {
			for(int i=0;i<4;i++) {
				if(nextMap[x][y] == directions[i]) {
					int bombX = x;
					int bombY = y;
					while(true) {
						bombX += dx[i];
						bombY += dy[i];
						if(bombX>=0 && bombX<h && bombY>=0 && bombY<w && nextMap[bombX][bombY] == '*') {
							nextMap[bombX][bombY] = '.';
							break;
						}
						if(bombX<0 || bombX>=h || bombY<0 || bombY>=w) break;
						if(nextMap[bombX][bombY] == '#') break;
					}
				}
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
		int testCase = sc.nextInt();
		for(int tc=1;tc<=testCase;tc++) {
			h = sc.nextInt();
			w = sc.nextInt();
			map = new char[h][w];
			nextMap = new char[h][w];
			
			for(int i=0;i<h;i++) {
				String str = sc.next();
				for(int j=0;j<w;j++) {
					map[i][j] = str.charAt(j);
					nextMap[i][j] = map[i][j];
					if(map[i][j] == '>' || map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v') {
						x = i;
						y = j;
					}
				}
			}
			n = sc.nextInt();
			String str = sc.next();
			for(int i=0;i<str.length();i++) {
				dfs(str.charAt(i));
			}
			System.out.print("#" + tc + " ");
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					System.out.print(nextMap[i][j]);
				}
				System.out.println();
			}
		}
	}
}