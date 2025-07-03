import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] children;
    static int score(int start, int end) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for(int i=start-1;i<end;i++) {
            if(children[i] > maxValue) maxValue = children[i];
            if(children[i] < minValue) minValue = children[i];
        }
        return maxValue - minValue;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        children = new int[n];
        for(int i=0;i<n;i++) {
            children[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        
        for(int i=2;i<=n;i++) {
            for(int j=1;j<i;j++) {
                dp[i] = Math.max(dp[i], dp[j-1] + score(j,i));
            }
        }
        System.out.println(dp[n]);
    }
}