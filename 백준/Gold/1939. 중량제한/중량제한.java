import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node{
        int index;
        int w;

        public Node(int index, int w) {
            this.index = index;
            this.w = w;
        }
    }
    
    static ArrayList<ArrayList<Node>> graph;
    static int n, m, ans, startPoint, endPoint;
    static boolean[] visited;

    static int binarySearch(int start, int end) {
        int mid = 0;
        while(start <= end) {
            mid = (start+end) / 2;
            visited = new boolean[n+1];
            bfs(startPoint, mid);

            if(visited[endPoint]) start = mid+1;
            else end = mid-1;
        }

        return end;
    }
    
    static void bfs(int start, int bound) {
        visited[start] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int now = q.poll();
            for(Node next : graph.get(now)) {
                if(!visited[next.index] && next.w >= bound) {
                    visited[next.index] = true;
                    q.add(next.index);
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<ArrayList<Node>>();
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        int max = 0;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            max = Math.max(max, c);

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch(0, max));     
    }
}