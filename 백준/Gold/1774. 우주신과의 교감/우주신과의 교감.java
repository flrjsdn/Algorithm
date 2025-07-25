import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node implements Comparable<Node>{
        int left;
        int right;
        double w;

        public Node(int left, int right, double w) {
            this.left = left;
            this.right = right;
            this.w = w;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(this.w, other.w);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int n,m;
    static int[] parent;

    static int findParent(int index) {
        if(index==parent[index]) return index;
        return parent[index] = findParent(parent[index]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    static double calDistance(int x1, int y1, int x2,int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
    }
    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            arr.add(new int[] {read(), read()});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j) continue;
                double d = calDistance(arr.get(i)[0], arr.get(i)[1], arr.get(j)[0], arr.get(j)[1]);
                pq.add(new Node(i+1, j+1, d));
            }
        }
        int cnt = 1;
        for(int i=0;i<m;i++) {
            int a = read();
            int b = read();
            if(findParent(a) != findParent(b)) {
                unionParent(a,b);
                cnt++;
            }
        }

        double ans = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(cnt == n) break;
            int a = findParent(now.left);
            int b = findParent(now.right);
            if(a != b) {
                unionParent(a,b);
                ans += now.w;
                cnt++;
            }
        }
        System.out.printf("%.2f", ans);
    }
}