import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static class Node implements Comparable<Node>{
        int index;
        int time;
        int w;

        public Node(int index, int time, int w) {
            this.index = index;
            this.time = time;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int N,T,M;
    static final int INF = (int) 1e9;
    static int[][] dist;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static void dijk(int start) {
        for(int i=2;i<=N;i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[start][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index][now.time] < now.w) continue;

            for(Node next : graph.get(now.index)) {
                int nextTime = now.time + next.time;
                int cost = dist[now.index][now.time] + next.w;
                if(nextTime > T || cost > M) continue;
                if(dist[next.index][nextTime] > cost) {
                    dist[next.index][nextTime] = cost;
                    pq.add(new Node(next.index, nextTime, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        N = read(); T = read(); M = read();
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N+1][T+1];
        int L = read();
        for(int i=0;i<L;i++) {
            int a = read();
            int b = read();
            int t = read();
            int c = read();
            graph.get(a).add(new Node(b,t,c));
            graph.get(b).add(new Node(a,t,c));
        }

        dijk(1);
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=T;i++) {
            ans = Math.min(ans, dist[N][i]);
        }
        if(ans == INF) System.out.println(-1);
        else System.out.println(ans);
    }
}