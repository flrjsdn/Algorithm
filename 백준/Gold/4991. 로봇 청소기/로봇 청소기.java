import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int W, H;
    static char[][] map;
    static List<int[]> nodes;
    static int[][] dist;
    static boolean[] visited;
    static int ans;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void calculateDistances() {
        int N = nodes.size();
        dist = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            int sX = nodes.get(i)[0];
            int sY = nodes.get(i)[1];
            
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{sX, sY, 0});
            int[][] currentDist = new int[H][W];
            for(int[] row : currentDist) Arrays.fill(row, -1);
            currentDist[sX][sY] = 0;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                int x = now[0];
                int y = now[1];
                int cost = now[2];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != 'x' && currentDist[nx][ny] == -1) {
                        currentDist[nx][ny] = cost + 1;
                        q.add(new int[]{nx, ny, cost + 1});
                    }
                }
            }
            
            for (int j = 0; j < N; j++) {
                int fX = nodes.get(j)[0];
                int fY = nodes.get(j)[1];
                dist[i][j] = currentDist[fX][fY];
                
                if (dist[i][j] == -1) {
                    ans = -1;
                    return;
                }
            }
        }
    }

    static void back(int depth, int current, int totalCost) {
        if (totalCost >= ans) return;

        if (depth == nodes.size() - 1) {
            ans = Math.min(ans, totalCost);
            return;
        }


        for (int i = 1; i < nodes.size(); i++) {
            if (!visited[i]) {
                int costToNext = dist[current][i];
                
                visited[i] = true;
                back(depth + 1, i, totalCost + costToNext);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            if (W == 0 && H == 0) break;

            map = new char[H][W];
            nodes = new ArrayList<>();

            for (int i = 0; i < H; i++) {
                String s = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] == 'o') {
                        nodes.add(0, new int[]{i, j}); 
                    } else if (map[i][j] == '*') {
                        nodes.add(new int[]{i, j});
                    }
                }
            }

            int N = nodes.size();
            ans = Integer.MAX_VALUE;
            calculateDistances();
            
            if (ans == -1) {
                sb.append("-1\n");
                continue;
            }

            visited = new boolean[N];
            back(0, 0, 0); 
            
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}