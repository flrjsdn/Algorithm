import java.util.*;
import java.io.*;

class Solution {
    static final int MOD = 1_000_000_007;
    static int[][] map;
    static int[][] dp;
    
    static int dfs(int x,int y) {
        if(dp[x][y] != 0) return dp[x][y];
        if(map[x][y] == 1) return 0;
        if(x<=0 || y<=0) return 0;
        if(x == 1 && y == 1) return 1;

        dp[x][y] = (dfs(x-1, y) + dfs(x,y-1)) % MOD;
        return dp[x][y];
    }
    public int solution(int m, int n, int[][] puddles) {
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++) {
            map[puddles[i][1]][puddles[i][0]] = 1;
        }
        int answer = dfs(n,m) % MOD;
        return answer;
    }
}