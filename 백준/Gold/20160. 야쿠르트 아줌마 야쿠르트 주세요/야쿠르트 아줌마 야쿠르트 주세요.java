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

    static int V,E;
    static final int INF = (int) 1e9;
    static int[] dist;
    static int[][] yakuDist;
    static List<Node>[] graph;

    static void dijk(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new Node(s,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.w) continue;

            for(Node next : graph[now.index]) {
                int cost = dist[now.index] + next.w;
                if(cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }

    static int dijkY(int s, int e) {
        int[] distY = new int[V+1];
        Arrays.fill(distY, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distY[s] = 0;
        pq.add(new Node(s,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.index == e) return distY[e];
            if(distY[now.index] < now.w) continue;

            for(Node next : graph[now.index]) {
                int cost = distY[now.index] + next.w;
                if(cost < distY[next.index]) {
                    distY[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) throws Exception {
        V = read(); E = read();
        graph = new ArrayList[V+1];
        dist = new int[V+1];
        
        Arrays.fill(dist, INF);
        for(int i=1;i<=V;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<E;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        int[] yaku = new int[10];
        for(int i=0;i<10;i++) {
            yaku[i] = read();
        }

        int y = read();
        dijk(y);
        long time = 0;
        int start = yaku[0];
        int end = 0;
        List<Integer> ans = new ArrayList<>();

        if(start == y) ans.add(y);
        
        for(int i=1;i<10;i++) {
            end = yaku[i];
            int t = dijkY(start, end);
            if(t==-1) continue;
            time += t;
            if(dist[end] <= time) ans.add(end);
            start = end;
        }
        Collections.sort(ans);
        if(ans.size() > 0) System.out.println(ans.get(0));
        else System.out.println(-1);
    }
}