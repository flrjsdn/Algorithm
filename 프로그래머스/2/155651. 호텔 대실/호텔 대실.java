class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] dp = new int[1500];
        for(int i=0;i<book_time.length;i++) {
            String[] start = book_time[i][0].split(":");
            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            String[] end = book_time[i][1].split(":");
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            dp[startTime] += 1;
            dp[endTime + 10] -= 1;
            System.out.println(startTime + " " + endTime);
        }
        
        
        for(int i=1;i<1500;i++) {
            dp[i] += dp[i-1];
            if(dp[i] > answer) answer = dp[i];
        }
        
        return answer;
    }
}