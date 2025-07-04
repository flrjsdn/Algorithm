import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node {
        int next;
        int w;

        public Node(int next, int w) {
            this.next = next;
            this.w = w;
        }
    }

    static int v,e,p;
    static int[] dist;
    static final int INF = (int) 1e9;

    static void dikj(int start) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
            return o1.w - o2.w;
        });

        pq.add(new Node(start,0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(dist[now.next] < now.w) continue;
            
            for(Node next : graph.get(now.next)) {
                if(dist[next.next] > dist[now.next] + next.w) {
                    dist[next.next] = dist[now.next] + next.w;
                    pq.add(new Node(next.next, dist[next.next]));
                }
            }
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0;i<=v;i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[v+1];
        for(int i=0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        dikj(1);
        int minP = dist[p];
        int minV = dist[v];

        dikj(p);
        int pToV = dist[v];

        if(minV == (minP + pToV)) System.out.println("SAVE HIM");
        else System.out.println("GOOD BYE");
        
        
    }
}