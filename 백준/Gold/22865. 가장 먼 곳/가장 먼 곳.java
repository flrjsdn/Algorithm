import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws IOException {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static class Node implements Comparable<Node> {
        int index;
        int w;

        public Node(int index,int w) {
            this.index = index;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int N, M;
    static final int INF = (int)1e9;
    static int[][] dist;
    static List<Node>[] graph;

    static void dijk(int idx, int start) {
        Arrays.fill(dist[idx], INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[idx][start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[idx][now.index] < now.w) continue;

            for(Node next : graph[now.index]) {
                int cost = dist[idx][now.index] + next.w;
                if(cost < dist[idx][next.index]) {
                    dist[idx][next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        N = read();
        int[] friends = new int[3];
        dist = new int[3][N+1];
        for(int i=0;i<3;i++) {
            friends[i] = read();
        }
        M = read();
        graph = new ArrayList[N+1];
        for(int i=0;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        for(int i=0;i<3;i++) {
            dijk(i, friends[i]);
        }

        int min = Integer.MIN_VALUE;
        int ans = 0;
        for(int i=1;i<=N;i++) {
            int value = Integer.MAX_VALUE;
            for(int j=0;j<3;j++) {
                value = Math.min(value, dist[j][i]);
            }
            if(min < value) {
                ans = i;
                min = value;
            }
        }
        System.out.println(ans);
    }
}