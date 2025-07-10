import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node {
        int t;
        int w;

        public Node(int t, int w) {
            this.t = t;
            this.w = w;
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long[] dist;
    static int n,m;
    static final int INF = (int) 1e9;

    static boolean bellman(int start) {
        dist[start] = 0;

        boolean flag = false;
        for(int i=1;i<n;i++) {
            flag = false;
            for(int j=1;j<=n;j++) {
                for(Node next : graph.get(j)) {
                    if(dist[j] == INF) break;

                    if(dist[next.t] > dist[j] + next.w) {
                        dist[next.t] = dist[j] + next.w;
                        flag = true;
                    }
                }
            }

            if(!flag) break;
        }

        if(flag) {
            for(int i=1;i<=n;i++) {
                for(Node next : graph.get(i)) {
                    if(dist[i] == INF) break;

                    if(dist[next.t] > dist[i] + next.w) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        dist = new long[n+1];
        Arrays.fill(dist, INF);
        
        for(int i=0;i<m;i++) {
            int a = read();
            int b = read();
            int c = read();
            graph.get(a).add(new Node(b,c));
        }

        if(bellman(1)) System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            for(int i=2;i<=n;i++) {
                if(dist[i] == INF) sb.append(-1).append("\n");
                else sb.append(dist[i]).append("\n");
            }
            System.out.println(sb);
        }
    }
}