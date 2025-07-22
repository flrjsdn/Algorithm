import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node implements Comparable<Node>{
        int a;
        int b;
        int w;

        public Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int n,m;
    static int[] parents;

    static int findParent(int index) {
        if(parents[index] == index) return index;
        return parents[index] = findParent(parents[index]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parents[a] = b;
        else parents[b] = a;
    }
    
    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        parents = new int[n+1];
        for(int i=0;i<=n;i++) {
            parents[i] = i;
        }

        long total = 0;
        for(int i=0;i<m;i++) {
            int a = read(), b = read(), c = read();
            total += c;
            pq.add(new Node(a,b,c));
        }

        long sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(findParent(now.a) != findParent(now.b)) {
                unionParent(now.a, now.b);
                sum += now.w;
                cnt++;
            }
            if(cnt == n-1) break;
        }
        if(cnt != n-1) System.out.println(-1);
        else System.out.println(total - sum);
    }
}