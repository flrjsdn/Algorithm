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
        int a;
        int b;
        int time;

        public Node(int a,int b,int time) {
            this.a = a;
            this.b = b;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
    }

    static int N,M,T;
    static int[] parent;

    static int findParent(int num) {
        if(parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    public static void main(String[] args) throws IOException {
        N = read(); M = read(); T = read();
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            pq.add(new Node(read(), read(), read()));
        }

        int cnt = N;
        long sum = 0;
        int beforeTime = 1;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            sum += (long)(now.time - beforeTime) * cnt;
            if(findParent(now.a) != findParent(now.b)) {
                unionParent(now.a,now.b);
                cnt--;
            }
            while(!pq.isEmpty() && now.time == pq.peek().time) {
                Node next = pq.poll();
                if(findParent(next.a) != findParent(next.b)) {
                    unionParent(next.a,next.b);
                    cnt--;
                }
            }
            beforeTime = now.time;
        }
        sum += (long)(T-beforeTime + 1) * cnt;
        System.out.println(sum);
    }
}