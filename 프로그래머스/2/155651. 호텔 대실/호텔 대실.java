import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bookList = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++) {
            String[] start = book_time[i][0].split(":");
            bookList[i][0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            bookList[i][1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]) + 10;
        }
        Arrays.sort(bookList, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(int i=0;i<book_time.length;i++) {
            while(!pq.isEmpty() && pq.peek()[1] <= bookList[i][0]) {
                pq.poll();
            }
            pq.add(bookList[i]);
            answer = Math.max(answer, pq.size());
            
        }
    
        
        return answer;
    }
}