import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node implements Comparable<Node>{
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

    static ArrayList<ArrayList<Node>> graph;
    static int[][] dist;
    static final int INF = (int) 1e9;
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static void dijk(int start, int room) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[room][start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[room][now.index] < now.w) continue;

            for(Node next : graph.get(now.index)) {
                int cost = dist[room][now.index] + next.w;
                if(dist[room][next.index] > cost) {
                    dist[room][next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++) {
            int n = read();
            int m = read();
            graph = new ArrayList<ArrayList<Node>>();
            for(int i=0;i<=n;i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0;i<m;i++) {
                int a = read();
                int b = read();
                int c = read();
                graph.get(a).add(new Node(b,c));
                graph.get(b).add(new Node(a,c));
            }

            int k = read();
            dist = new int[k+1][n+1];

            for(int i=1;i<=k;i++) {
                Arrays.fill(dist[i], INF);
            }
            for(int i=1;i<=k;i++) {
                int a = read();
                dijk(a, i);
            }

            int min = Integer.MAX_VALUE;
            int ans = -1;
            for(int i=1;i<=n;i++) {
                int sum = 0;
                for(int j=1;j<=k;j++) {
                    sum += dist[j][i];
                }
                if(sum < min) {
                    min = sum;
                    ans = i;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}