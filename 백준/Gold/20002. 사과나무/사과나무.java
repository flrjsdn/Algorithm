import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        int ans = Integer.MIN_VALUE;
        StringTokenizer st;
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++) {
                int now = Integer.parseInt(st.nextToken());
                ans = Math.max(ans, now);
                map[i][j] = map[i][j-1] + map[i-1][j] - map[i-1][j-1] + now;
            }
        }

        for(int size=2;size<=n;size++) {
            for(int i=size;i<=n;i++) {
                for(int j=size;j<=n;j++) {
                    int cal = map[i][j] - map[i-size][j] - map[i][j-size] + map[i-size][j-size];
                    ans = Math.max(ans, cal);
                }
            }
        }
        System.out.println(ans);
    }
}