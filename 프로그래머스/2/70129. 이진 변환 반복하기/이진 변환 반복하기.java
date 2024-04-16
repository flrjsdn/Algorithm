class Solution {
    public int[] solution(String s) {
        int cnt0 = 0;
        int cntTotal = 0;
        while(s.length() != 1) {
            int oneNum = 0;
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i) == '0') cnt0++;
                else oneNum += 1;
            }
            s = Integer.toBinaryString(oneNum);
            cntTotal++;
        }
        int[] answer = {cntTotal, cnt0};
        return answer;
    }
}