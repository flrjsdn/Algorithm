import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node implements Comparable<Node>{
        int dead;
        int lamen;

        public Node(int dead, int lamen) {
            this.dead = dead;
            this.lamen = lamen;
        }

        @Override
        public int compareTo(Node other) {
            if(this.dead == other.dead) {
                return Integer.compare(other.lamen, this.lamen);
            }
            return Integer.compare(this.dead, other.dead);
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr.add(new Node(d,l));
        }
        Collections.sort(arr);

        int ans = 0;
        for(int i=0;i<n;i++) {
            Node now = arr.get(i);

            if(pq.size() < now.dead) pq.add(now.lamen);
            else if(pq.size() == now.dead) {
                if(pq.peek() < now.lamen) {
                    pq.poll();
                    pq.add(now.lamen);
                }
            }
        }
        while(!pq.isEmpty()) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}