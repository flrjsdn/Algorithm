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
        int start;
        int v;

        public Node(int start, int v) {
            this.start = start;
            this.v = v;
        }

        @Override
        public int compareTo(Node other) {
            if(this.v == other.v) {
                return Integer.compare(this.start, other.start);
            }
            return Integer.compare(other.v, this.v);
        }

        @Override
        public String toString() {
            return this.start + " " + this.v;
        }
    }

    static int N,S;
    static int[] T,V;
    static Node[] nList;
    public static void main(String[] args) throws Exception {
        int Test = read();
        StringBuilder sb = new StringBuilder();
        for(int tc = 0;tc<Test;tc++) {
            N = read();
            S = read();
            T = new int[N];
            V = new int[N];
            nList = new Node[N];
            for(int i=0;i<N;i++) {
                T[i] = read();
            }
            for(int i=0;i<N;i++) {
                V[i] = read();
            }

            for(int i=0;i<N;i++) {
                nList[i] = new Node(T[i], V[i]);
            }

            long ans = 0;
            Arrays.sort(nList, (o1,o2) -> (o1.start - o2.start));
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int index = 0;
            while (index < N || !pq.isEmpty()) {
                while (index < N && nList[index].start <= S) {
                    pq.add(nList[index++]);
                }

                if (!pq.isEmpty()) {
                    Node now = pq.poll();
                    ans += (long)(S - now.start) * now.v;
                    S++;
                } else {
                    S = nList[index].start;
                }
            }
            
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}