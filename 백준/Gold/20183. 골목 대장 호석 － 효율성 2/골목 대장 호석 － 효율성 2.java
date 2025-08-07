import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int index;
        int w;
        long total;

        public Node(int index,int w) {
            this.index = index;
            this.w = w;
        }

        public Node(int index,int w, long total) {
            this.index = index;
            this.w = w;
            this.total = total;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int n,m, A, B;
    static long C;
    static long[] dist;
    static boolean[] visited;
    static final long INF = (long) 1e16;
    static boolean ans;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        visited[start] = true;
        pq.add(new Node(start, 0, C));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.w) continue;
            if(now.index == B) {
                ans = true;
                return;
            }

            for(Node next : graph.get(now.index)) {
                if(now.total - next.w < 0) continue;
                if(!visited[next.index]) {
                    visited[next.index] = true;
                    dist[next.index] = Math.max(next.w, dist[now.index]);
                    pq.add(new Node(next.index, (int) dist[next.index], now.total-next.w));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        dist = new long[n+1];
        visited = new boolean[n+1];
        Arrays.fill(dist, INF);

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        ans = false;
        dijk(A);
        if(ans) System.out.println(dist[B]);
        else System.out.println(-1);
    }
}