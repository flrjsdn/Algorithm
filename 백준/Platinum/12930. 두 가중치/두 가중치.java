import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int index;
        int w;
        int sum1;
        int sum2;

        public Node(int index,int w, int sum1, int sum2) {
            this.index = index;
            this.w = w;
            this.sum1 = sum1;
            this.sum2 = sum2;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.w, other.w);
        }
    }

    static int N;
    static final int INF = (int) 1e9;
    static final int MAX_W = 180;
    static int[][] dist;
    static int[][] weight1, weight2;

    static int dijk(int start) {
        dist = new int[N][MAX_W+1];
        for(int i=0;i<N;i++) {
            Arrays.fill(dist[i], INF);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0,0,0));
        dist[start][0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.index==1) return now.w;
            if(dist[now.index][now.sum1] < now.sum2) continue;

            for(int i=0;i<N;i++) {
                if(weight1[now.index][i] == -1) continue;
                int w1 = now.sum1 + weight1[now.index][i];
                int w2 = now.sum2 + weight2[now.index][i];
                int cost = w1*w2;
                if(dist[i][w1] > w2) {
                    dist[i][w1] = w2;
                    pq.add(new Node(i,cost,w1,w2));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        weight1 = new int[N][N];
        weight2 = new int[N][N];
        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                char c = s.charAt(j);
                if(c=='.') weight1[i][j] = -1;
                else weight1[i][j] = c - '0';
            }
        }

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            for(int j=0;j<N;j++) {
                char c = s.charAt(j);
                if(c=='.') weight2[i][j] = -1;
                else weight2[i][j] = c - '0';
            }
        }
        System.out.println(dijk(0));
    }
}