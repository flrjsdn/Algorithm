import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static class Node implements Comparable<Node> {
        int index;
        long w;

        public Node(int index, long w) {
            this.index = index;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.w, other.w);
        }
    }

    static int N, M, A, B;
    static final long INF = (long) 1e15;
    static long[] dist;
    static List<Integer>[] parents;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    static void dijk(int start) {
        Arrays.fill(dist, INF);
        for (int i = 0; i <= N; i++) parents[i].clear();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dist[now.index] < now.w) continue;

            for (Node next : graph.get(now.index)) {
                long cost = dist[now.index] + next.w;

                if (dist[next.index] > cost) {
                    dist[next.index] = cost;
                    parents[next.index].clear();
                    parents[next.index].add(now.index);
                    pq.add(new Node(next.index, cost));
                } else if (dist[next.index] == cost) {
                    parents[next.index].add(now.index);
                }
            }
        }
    }

    static void collectNodes(int v, boolean[] visited, Set<Integer> result) {
        if (visited[v]) return;
        visited[v] = true;
        result.add(v);
        for (int p : parents[v]) {
            collectNodes(p, visited, result);
        }
    }

    public static void main(String[] args) throws Exception {
        N = read(); M = read(); A = read(); B = read();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        dist = new long[N + 1];
        parents = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) parents[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            int c = read();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijk(A);

        Set<Integer> nodes = new TreeSet<>();
        collectNodes(B, new boolean[N + 1], nodes);

        StringBuilder sb = new StringBuilder();
        sb.append(nodes.size()).append("\n");
        for (int v : nodes) sb.append(v).append(" ");
        System.out.println(sb);
    }
}
