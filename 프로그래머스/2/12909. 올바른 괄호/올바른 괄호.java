class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int result = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') result += 1;
            else result -= 1;
            if(result < 0) {
                answer = false;
                break;
            }
        }
        if(result != 0) answer = false;

        return answer;
    }
}