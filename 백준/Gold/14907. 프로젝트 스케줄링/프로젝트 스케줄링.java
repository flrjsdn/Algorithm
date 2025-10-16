import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int index;
        int t;

        public Node(int index,int t) {
            this.index = index;
            this.t = t;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.t, other.t);
        }
    }

    static int[] indegree;
    static int[] times;
    static int N;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        N = 26;
        indegree = new int[N];
        times = new int[N];
        graph = new ArrayList[N];
        
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList<>();
        }
        
        while(true) {
            String s = br.readLine();
            if(s==null) break;
            String[] sList = s.split(" ");
            int to = sList[0].charAt(0) - 'A';
            times[to] = Integer.parseInt(sList[1]);
            if(sList.length > 2) {
                for(int i=0;i<sList[2].length();i++) {
                    indegree[to] += 1;
                    graph[sList[2].charAt(i) - 'A'].add(to);
                }
            }
        }

        int time = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            if(indegree[i] == 0) {
                pq.add(new Node(i,times[i]));
            }
        }
        
        while(true) {
            if(pq.isEmpty()) break;
            time++;
            while(!pq.isEmpty() && pq.peek().t == time) {
                Node now = pq.poll();
                for(int next : graph[now.index]) {
                    indegree[next] -= 1;
                    if(indegree[next] == 0) {
                        pq.add(new Node(next, times[next] + time));
                    }
                }
            }
        }
        System.out.println(time);
    }
}