import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;

        Map<String, Integer> result = new HashMap<>();
        for(int i=0;i<want.length;i++) {
            result.put(want[i], number[i]);
        }

        for(int i=0;i<discount.length - 10 + 1;i++) {
            Map<String, Integer> map = new HashMap<>();

            for(int j=0;j<days;j++) {
                map.put(discount[i+j], map.getOrDefault(discount[i+j], 0) + 1);
            }

            boolean check = true;
            for(String key : map.keySet()) {
                if(map.get(key) != result.get(key)) {
                    check = false;
                    break;
                }
            }
            answer += check ? 1 : 0;
        }
        return answer;
    }
}