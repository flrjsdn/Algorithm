import java.util.*;

class Solution {
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;
    
    boolean bfs(int x,int y, String[] map) {
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y, 0});
        boolean result = true;
        s: while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[2] == 2) break;
            
            for(int i=0;i<4;i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=5 || ny<0 || ny>=5 || map[nx].charAt(ny) == 'X') continue;
                if(!visited[nx][ny]) {
                    if(map[nx].charAt(ny) == 'P') {
                        result = false;
                        break s;
                    }
                    else {
                        q.add(new int[] {nx,ny,now[2]+1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return result;
        
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int k=0;k<5;k++) {
            String[] map = places[k];
            int ans = 1;
            s: for(int i=0;i<5;i++) {
                String s = map[i];
                for(int j=0;j<5;j++) {
                    if(s.charAt(j) == 'P') {
                        visited = new boolean[5][5];
                        if(!bfs(i,j,map)) {
                            ans = 0;
                            break s;
                        }
                    }
                }
            }
            
            answer[k] = ans;
        }
        return answer;
    }
}