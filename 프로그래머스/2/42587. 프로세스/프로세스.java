import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int i=0;i<priorities.length;i++) {
            pq.add(priorities[i]);
        }
        
        int index = 0;
        while(!pq.isEmpty()) {
            if(priorities[index] == pq.peek()) {
                pq.poll();
                answer++;
                if(index == location) break;
                index = (index + 1) % priorities.length;
            } else {
                index = (index + 1) % priorities.length;
            }
        }
        return answer;
    }
}