class Solution {
    public int findOne(String str) {
        int cnt = 0;
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '1') cnt ++;
        }
        return cnt;
    }
    public int solution(int n) {
        int answer = 0;
        int nextNum = n+1;
        String str = Integer.toBinaryString(n);
        int nOne = findOne(str);
        while(true) {
            String str2 = Integer.toBinaryString(nextNum);
            int str2One = findOne(str2);
            if(nOne == str2One) {
                answer = nextNum;
                break;
            }
            nextNum++;
        }
        return answer;
    }
}