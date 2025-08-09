import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Edge implements Comparable<Edge> {
        int left;
        int right;
        int w;

        public Edge(int left, int right,int w) {
            this.left = left;
            this.right = right;
            this.w = w;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int N,M;
    static int[] parent;
    static char[] gender;

    static int findParent(int num) {
        if(parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }
        gender = new char[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            gender[i] = st.nextToken().charAt(0);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(gender[a] != gender[b]) {
                pq.add(new Edge(a,b,c));
            }
        }

        int cnt = 1;
        int ans = 0;
        while(!pq.isEmpty()) {
            if(cnt == N) break;
            Edge now = pq.poll();
            if(findParent(now.left) != findParent(now.right)) {
                unionParent(now.left, now.right);
                ans += now.w;
                cnt++;
            }
        }
        if(cnt != N) System.out.println(-1);
        else System.out.println(ans);
    }
}