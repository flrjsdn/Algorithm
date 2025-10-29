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
        int from;
        int to;
        int w;

        public Node(int from, int to, int w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int N,M;
    static int[] parent;

    static int findParent(int num) {
        if(num == parent[num]) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++) {
            N = read(); M = read();
            PriorityQueue<Node> pq = new PriorityQueue<>();
            PriorityQueue<Node> nextPq = new PriorityQueue<>();
            
            for(int i=1;i<N;i++) {
                int a = read();
                int b = read();
                nextPq.add(new Node(i,a,b));
            }

            long ans = 0;
            for(int i=0;i<M;i++) {
                pq = nextPq;
                int a = read();
                int b = read();
                int c = read();
                pq.add(new Node(a,b,c));

                parent = new int[N];
                for(int j=0;j<N;j++) {
                    parent[j] = j;
                }
                nextPq = new PriorityQueue<>();
                long sum = 0;
                while(!pq.isEmpty()) {
                    Node now = pq.poll();
                    nextPq.add(now);

                    int from = findParent(now.from);
                    int to = findParent(now.to);
                    if(from != to) {
                        unionParent(from, to);
                        sum += now.w;
                    }
                }
                ans = ans ^ sum;
            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}