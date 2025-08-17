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

    static class Node implements Comparable<Node> {
        int index;
        long w;

        public Node(int index,long w) {
            this.index = index;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.w, other.w);
        }
    }

    static int N,M,D,E;
    static final long INF = (long) 1e15;
    static int[] heights;
    static long[] distStart;
    static long[] distEnd;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

    static long[] dijk(int start) {
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.w) continue;
            for(Node next : graph.get(now.index)) {
                if(heights[next.index] <= heights[now.index]) continue;
                long cost = dist[now.index] + next.w;
                if(dist[next.index] > cost) {
                    dist[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }

        return dist;
    }
    
    public static void main(String[] args) throws Exception {
        N = read(); M = read(); D = read(); E = read();
        heights = new int[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=1;i<=N;i++) {
            heights[i] = read();
        }
        

        for(int i=0;i<M;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        distStart = dijk(1);
        distEnd = dijk(N);
        long ans = Long.MIN_VALUE;
        for(int i=2;i<N;i++) {
            if(distStart[i] == INF || distEnd[i] == INF) continue;
            long distance = (heights[i] * E) - (D * (distStart[i] + distEnd[i]));
            ans = Math.max(distance, ans);
        }
        if(ans == Long.MIN_VALUE) System.out.println("Impossible");
        else System.out.println(ans);
    }
}