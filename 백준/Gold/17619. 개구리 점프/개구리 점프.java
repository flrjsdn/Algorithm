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
        int x1;
        int x2;
        int idx;

        public Node(int x1,int x2, int idx) {
            this.x1 = x1;
            this.x2 = x2;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node other) {
            if(this.x1 == other.x1) return Integer.compare(this.x2, other.x2);
            return Integer.compare(this.x1, other.x1);
        }
    }

    static int N,Q;
    static int[] parent;

    static int findParent(int num) {
        if(parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    public static void main(String[] args) throws Exception {
        N = read(); Q = read();
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        List<Node> graph = new ArrayList<>();
        for(int i=0;i<N;i++) {
            graph.add(new Node(read(),read(), i+1));
            read();
        }
        Collections.sort(graph);
        int start = graph.get(0).x1;
        int end = graph.get(0).x2;
        int before = graph.get(0).idx;
        
        for(int i=1;i<N;i++) {
            Node now = graph.get(i);
            if(now.x1 >= start && now.x1 <= end) {
                if(findParent(before) != findParent(now.idx)) unionParent(before,now.idx);
                end = Math.max(end, now.x2);
            } else {
                start = now.x1;
                end = now.x2;
                before = now.idx;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++) {
            int a = read();
            int b = read();
            if(findParent(a) == findParent(b)) sb.append(1 + "\n");
            else sb.append(0 + "\n");
        }
        System.out.println(sb);
    }
}