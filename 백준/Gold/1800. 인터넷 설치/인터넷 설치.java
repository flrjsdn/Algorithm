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

    static class Edge implements Comparable<Edge> {
        int index;
        int w;

        public Edge(int index,int w) {
            this.index = index;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static boolean dijk(int s) {
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[1] = 0;
        pq.add(new Edge(1, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(dist[now.index] < now.w) continue;

            for(Edge next : graph.get(now.index)) {
                int nextW = now.w;
                if(next.w > s) nextW += 1;
                if(nextW < dist[next.index]) {
                    dist[next.index] = nextW;
                    pq.add(new Edge(next.index, nextW));
                }
            }
        }

        return dist[n] <= k;
    }

    static int n,p,k;
    static final int INF = (int) 1e9;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();
    static int[] dist;
    public static void main(String[] args) throws Exception {
        n = read(); p = read(); k = read();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[n+1];
        
        int start = 0;
        int end = 0;
        for(int i=0;i<p;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
            end = Math.max(end, c);
        }

        int ans = Integer.MAX_VALUE;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(dijk(mid)) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else start = mid + 1;
        }

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}