import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n;i++) {
            set.add(br.readLine());
        }

        int[] dp = new int[s.length()+1];
        dp[s.length()] = 1;
        for(int i=s.length()-1;i>=0;i--) {
            for(int j=i+1;j<=s.length();j++) {
                if(dp[j]==1) {
                    if(set.contains(s.substring(i,j))) {
                        dp[i] = 1;
                    }
                }
            }
        }
        System.out.println(dp[0]);
    }
}