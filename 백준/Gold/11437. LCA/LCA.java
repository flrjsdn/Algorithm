import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int n;
    static int[] depth;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static void init(int nod, int dep, int pat) {
        depth[nod] = dep;
        for(int next : graph.get(nod)) {
            if(next != pat) {
                dp[next][0] = nod;
                init(next, dep+1, nod);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }
        depth = new int[n+1];
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        dp = new int[n+1][h+1];
        
        StringTokenizer st;
        for(int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        init(1,1,0);

        for(int j=1;j<h;j++) {
            for(int i=1;i<=n;i++) {
                dp[i][j] = dp[dp[i][j-1]][j-1];
            }
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(depth[a] > depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            for(int j=h-1;j>=0;j--) {
                if(depth[b] - depth[a] >= Math.pow(2,j)) {
                    b = dp[b][j];
                }
            }
            if(a==b) {
                sb.append(a + "\n");
                continue;
            }
            for(int j=h-1;j>=0;j--) {
                if(dp[a][j] != dp[b][j]) {
                    a = dp[a][j];
                    b = dp[b][j];
                }
            }
            sb.append(dp[a][0] + "\n");
        }
        System.out.println(sb);
    }
}