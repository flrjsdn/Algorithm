import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node {
        int left;
        int right;
        int w;

        public Node(int left, int right, int w) {
            this.left = left;
            this.right = right;
            this.w = w;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int n,m,cnt;
    static int x,k;
    static ArrayList<Integer> arr;
    static int[] parent;

    static int findParent(int index) {
        if(index == parent[index]) return index;
        return parent[index] = findParent(parent[index]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }

        cnt = 1;
        for(int i=0;i<m;i++) {
            int a = findParent(read());
            int b = findParent(read());
            if(a != b) {
                unionParent(a,b);
                cnt++;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.w - o2.w);
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                int w = read();
                if(i >= j || i == 1 || j == 1) continue;
                int a = findParent(i);
                int b = findParent(j);
                if(a != b) {
                    pq.add(new Node(i,j,w));
                }
            }
        }

        arr = new ArrayList<>();
        x = 0; k = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(cnt == n-1) break;
            int a = findParent(now.left);
            int b = findParent(now.right);
            if(a != b) {
                unionParent(a,b);
                x += now.w;
                k++;
                arr.add(now.left);
                arr.add(now.right);
                cnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(x + " " + k + "\n");
        for(int num : arr) {
            sb.append(num + " ");
        }
        System.out.println(sb);
    }
}