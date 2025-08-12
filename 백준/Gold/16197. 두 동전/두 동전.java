import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int sX1 = -1, sY1 = -1, sX2 = -1, sY2 = -1;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'o') {
                    if (sX1 == -1) {
                        sX1 = i; sY1 = j;
                    } else {
                        sX2 = i; sY2 = j;
                    }
                    map[i][j] = '.'; // 'o'를 빈칸으로 바꿔서 이동 처리 쉽게 함
                }
            }
        }

        System.out.println(bfs(sX1, sY1, sX2, sY2));
    }

    static int bfs(int sx1, int sy1, int sx2, int sy2) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx1, sy1, sx2, sy2, 0});
        visited[sx1][sy1][sx2][sy2] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3], d = cur[4];

            if (d >= 10) continue; // 더 이상 이동 불가 (다음 이동이 11이 되므로)

            for (int i = 0; i < 4; i++) {
                int nx1 = x1 + dx[i], ny1 = y1 + dy[i];
                int nx2 = x2 + dx[i], ny2 = y2 + dy[i];

                boolean fall1 = (nx1 < 0 || nx1 >= N || ny1 < 0 || ny1 >= M);
                boolean fall2 = (nx2 < 0 || nx2 >= N || ny2 < 0 || ny2 >= M);

                if (fall1 && fall2) continue;         // 둘 다 떨어지면 무시
                if (fall1 ^ fall2) return d + 1;     // 정확히 하나만 떨어지면 정답

                // 둘 다 아직 보드 안에 있으면, 벽이면 제자리 유지
                if (map[nx1][ny1] == '#') { nx1 = x1; ny1 = y1; }
                if (map[nx2][ny2] == '#') { nx2 = x2; ny2 = y2; }

                if (!visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.add(new int[]{nx1, ny1, nx2, ny2, d + 1});
                }
            }
        }
        return -1; // 10번 이하로 만들 수 없는 경우
    }
}
