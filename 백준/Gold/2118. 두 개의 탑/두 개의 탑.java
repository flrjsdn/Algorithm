import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] map = new int[n+1];

        int sum = 0;
        for(int i=0;i<n;i++) {
            map[i] = Integer.parseInt(br.readLine());
            sum += map[i];
        }

        int start = 0;
        int end = 0;

        int result = 0;
        int now = map[start];
        while(start<=end && end<n) {
            int min = Math.min(now, sum-now);
            result = Math.max(result, min);

            if(now == min) {
                end++;
                now += map[end];
            } else {
                now -= map[start];
                start++;
            }
        }
        System.out.println(result); 
    }
}