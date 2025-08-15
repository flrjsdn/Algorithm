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

    static int N,M;
    static final int INF = (int) 1e9;
    static int[] dist;

    static void dijk(int start, int end) {
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        ArrayList<Integer> nodeList = new ArrayList<>();
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.index] < now.w) continue;
            for(Node next : graph.get(now.index)) {
                int cost = dist[now.index] + next.w;
                if(dist[next.index] > cost) {
                    dist[next.index] = cost;
                    map.get(next.index).clear();
                    for(int num : map.get(now.index)) {
                        map.get(next.index).add(num);
                    }
                    map.get(next.index).add(now.index);
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    public static void main(String[] args) throws Exception {
        N = read(); M = read();
        dist = new int[N+1];
        for(int i=0;i<=N;i++) {
            graph.add(new ArrayList<>());
            map.put(i, new ArrayList<>());
        }
        
        for(int i=0;i<M;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph.get(a).add(new Node(b,c));
        }

        int start = read(), end = read();
        dijk(start, end);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[end] + "\n");
        sb.append(map.get(end).size()+1 + "\n");
        for(int i=0;i<map.get(end).size();i++) {
            sb.append(map.get(end).get(i) + " ");
        }
        sb.append(end);
        System.out.println(sb.toString());
    }
}