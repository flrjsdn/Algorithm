import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Node implements Comparable<Node>{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.start, other.start);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Node(s,e));
        }

        int endPoint = 0;
        int ans = 0;
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            //현재 지점이 널판지가 안겹칠 때
            if(now.start > endPoint) {
                endPoint = now.start + l - 1;
                ans++;
            }

            //다 채울때까지 반복
            while(endPoint < now.end-1) {
                ans++;
                endPoint += l;
                // System.out.print(endPoint + " ");
            }
            
        }
        System.out.println(ans);
    }
}