import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static int[] dx = {0,-1,-1,-1,0,1,1,1}; //왼쪽 부터 시계 방향
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[] sx = {-1,0,1,0}; //상어 이동 방향 1,2,3,4
    static int[] sy = {0,-1,0,1};
    static int sharkX, sharkY;
    static int calD, eatS; // 방향 계산을 위한 수
    static boolean[][] visited;
    
    static ArrayList<Integer>[][] fishMap;
    static ArrayList<Integer>[][] temp;
    static int[][] sharkMap;

    //물고기가 이동 -> 상어 있는 칸, 물고기 냄새 칸, 격자 범위 넘어가는 칸은 제외
    static void play() {
        temp = new ArrayList[n+1][n+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                temp[i][j] = new ArrayList<>();
            }
        }

        //냄새 없애기
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(sharkMap[i][j] > 0) sharkMap[i][j] -= 1;
            }
        }
        
        //모든 물고기 temp 배열에 이동하여 저장
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                for(int direction : fishMap[i][j]) {
                    int d = findDirection(i,j,direction);
                    if(d == -1) {
                        temp[i][j].add(direction);
                    } else {
                        int nx = i + dx[d-1];
                        int ny = j + dy[d-1];
                        temp[nx][ny].add(d);
                    } 
                }
            }
        }
        
        
        //상어의 이동
        calD = Integer.MAX_VALUE;
        eatS = -1;
        visited = new boolean[n+1][n+1];
        dfs(sharkX, sharkY, 0,0,0);
        int first = calD / 100;
        int second = (calD % 100) / 10;
        int last = calD % 10;
        
        //1번째 이동       
        sharkX += sx[first-1];
        sharkY += sy[first-1];
        if(temp[sharkX][sharkY].size() != 0) {
            temp[sharkX][sharkY].clear();
            sharkMap[sharkX][sharkY] = 3;
        }

        //2번째 이동
        sharkX += sx[second-1];
        sharkY += sy[second-1];
        if(temp[sharkX][sharkY].size() != 0) {
            temp[sharkX][sharkY].clear();
            sharkMap[sharkX][sharkY] = 3;
        }

        //3번째 이동
        sharkX += sx[last-1];
        sharkY += sy[last-1];
        if(temp[sharkX][sharkY].size() != 0) {
            temp[sharkX][sharkY].clear();
            sharkMap[sharkX][sharkY] = 3;
        }

        //복사 진행
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                for(int direction : temp[i][j]) {
                    fishMap[i][j].add(direction);
                }
            }
        }
    }

    static int findDirection(int x,int y,int d) {
        int cnt = 0;
        while(true) {
            if(cnt == 8) return -1;
            cnt++;
            int nx = x + dx[d-1];
            int ny = y + dy[d-1];
            if(nx<=0 || nx>n || ny<=0 || ny>n || sharkMap[nx][ny] != 0 || 
              (sharkX == nx && sharkY == ny)) {
                d = d-1 <= 0 ? 8 : d-1;
                continue;
            } else {
                break;
            }
        }
        return d;
    }

    //상어가 이동 -> 물고기가 제일 많은 곳으로 찾기(DFS로 찾기)
    //이동하면서 먹은 부분을 물고기 냄새 표시

    static void dfs(int x,int y, int depth, int sum, int eat) {
        if(depth == 3) {
            if(eat > eatS) {
                calD = sum;
                eatS = eat;
            }else if(eat == eatS) {
                calD = Math.min(calD, sum);
            }
            return;
        }

        for(int i=1;i<=n;i++) {
            int nx = x + sx[i-1];
            int ny = y + sy[i-1];
            if(nx<=0 || nx>n || ny<=0 || ny>n) continue;
            if(visited[nx][ny]) {
                dfs(nx,ny,depth+1, sum*10+i, eat);
            } else {
                visited[nx][ny] = true;
                dfs(nx,ny,depth+1, sum*10+i, eat + temp[nx][ny].size());
                visited[nx][ny] = false;
            }
        }
    }
    

    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        n = 4;

        fishMap = new ArrayList[n+1][n+1];
        sharkMap = new int[n+1][n+1];
        
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                fishMap[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fishMap[a][b].add(d);
        }
        st = new StringTokenizer(br.readLine());
        sharkX = Integer.parseInt(st.nextToken());
        sharkY = Integer.parseInt(st.nextToken());

        while(s-- > 0) {
            play();
        }

        int ans = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                ans += fishMap[i][j].size();
            }
        }
        System.out.println(ans);
    }
}