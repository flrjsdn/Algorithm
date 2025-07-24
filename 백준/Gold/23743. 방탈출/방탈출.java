import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node implements Comparable<Node>{
        int left;
        int right;
        int w;

        public Node(int left, int right, int w) {
            this.left = left;
            this.right = right;
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

    static int n,m, cnt;
    static long ans;
    static int[] parent;
    static boolean[] visited;

    static int findParent(int index) {
        if(index == parent[index]) return index;
        return parent[index] = findParent(parent[index]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) {
            parent[a] = b;
        }
        else {
            parent[b] = a;
        }
    }
    
    public static void main(String[] args) throws Exception{
        n = read(); m = read();
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<m;i++) {
            int a = read();
            int b = read();
            int c = read();
            pq.add(new Node(a,b,c));
        }
        for(int i=1;i<=n;i++) {
            int w = read();
            pq.add(new Node(0,i,w));
        }

        ans = 0;
        cnt = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(findParent(now.left) != findParent(now.right)) {
                unionParent(now.left, now.right);
                ans += now.w;
                cnt++;
            }

            if(cnt == n) break;
        }
        System.out.println(ans);
    }
}