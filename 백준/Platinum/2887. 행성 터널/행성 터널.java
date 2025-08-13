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

    static class Planet {
        int x;
        int y;
        int z;

        public Planet(int x,int y,int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

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

    static int N;
    static int[] parent;
    static Planet[] pList;

    static int findParent(int num) {
        if(parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);

        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    
    public static void main(String[] args) throws Exception {
        N = read();
        parent = new int[N+1];
        pList = new Planet[N+1];
        for(int i=1;i<=N;i++) {
            parent[i] = i;
        }

        for(int i=1;i<=N;i++) {
            pList[i] = new Planet(read(), read(), read());
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        List<int[]> xList = new ArrayList<>();
        List<int[]> yList = new ArrayList<>();
        List<int[]> zList = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            xList.add(new int[] {pList[i].x, i});
            yList.add(new int[] {pList[i].y, i});
            zList.add(new int[] {pList[i].z, i});
        }
        xList.sort(Comparator.comparingInt(a -> a[0])); 
        yList.sort(Comparator.comparingInt(a -> a[0])); 
        zList.sort(Comparator.comparingInt(a -> a[0]));
        
        for(int i=0;i<N-1;i++) {
            int x = Math.abs(xList.get(i)[0] - xList.get(i+1)[0]);
            int y = Math.abs(yList.get(i)[0] - yList.get(i+1)[0]);
            int z = Math.abs(zList.get(i)[0] - zList.get(i+1)[0]);
            pq.add(new Node(xList.get(i)[1], xList.get(i+1)[1], x));
            pq.add(new Node(yList.get(i)[1], yList.get(i+1)[1], y));
            pq.add(new Node(zList.get(i)[1], zList.get(i+1)[1], z));
        }

        int cnt = 1;
        int ans = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(cnt == N) break;
            if(findParent(now.left) != findParent(now.right)) {
                unionParent(now.left, now.right);
                ans += now.w;
                cnt++;
            }
        }
        System.out.println(ans);
    }
}