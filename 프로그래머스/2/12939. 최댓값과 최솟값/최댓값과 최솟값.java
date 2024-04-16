import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length;i++) {
            if(Integer.parseInt(str[i]) > max) max = Integer.parseInt(str[i]);
            if(Integer.parseInt(str[i]) < min) min = Integer.parseInt(str[i]);
        }
        
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}