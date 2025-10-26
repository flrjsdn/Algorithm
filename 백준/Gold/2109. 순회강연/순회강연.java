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
        int p;
        int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node other) {
            if(this.p == other.p) return Integer.compare(this.d, other.d);
            return Integer.compare(other.p, this.p);
        }
    }

    static int N;
    static int[] parent;
    static final int INF = 10_000;

    static int findParent(int num) {
        if(num == parent[num]) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        N = read();
        parent = new int[INF+1];
        for(int i=1;i<=INF;i++) {
            parent[i] = i;
        }
        for(int i=0;i<N;i++) {
            pq.add(new Node(read(), read()));
        }

        int ans = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(findParent(now.d) != 0) {
                int num = findParent(now.d);
                unionParent(num, num-1);
                ans += now.p;
            }
        }
        System.out.println(ans);
    }
}