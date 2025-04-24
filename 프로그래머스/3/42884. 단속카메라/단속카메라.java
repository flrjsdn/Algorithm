import java.util.*;

class Solution {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Node other) {
            if(this.start == other.start) {
                return Integer.compare(other.end, this.end);
            }
            return Integer.compare(this.start, other.start);
        }
        
    }
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0;i<routes.length;i++) {
            pq.add(new Node(routes[i][0], routes[i][1]));
        }
        
        Node now = pq.poll();
        answer = 1;
        int s = now.start;
        int e = now.end;
        while(!pq.isEmpty()) {
            if(pq.peek().start >= s && pq.peek().start <= e) {
                Node next = pq.poll();
                s = next.start;
                if(next.end < e) e = next.end;
            } else {
                answer++;
                now = pq.poll();
                s = now.start;
                e = now.end;
            }
        }
        
        return answer;
    }
}