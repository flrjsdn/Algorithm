import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static final int INF = (int) 1e9;
    static class Node {
        int cost;
        int p;

        public Node(int cost, int p) {
            this.cost = cost;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Node[] arr = new Node[n+1];
        int[] dp = new int[c+1];
        Arrays.fill(dp, INF);
        
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            arr[i] = new Node(cost,people);
        }

        dp[0] = 0;
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=c;j++) {
                if(dp[j] != INF) {
                    if(j+arr[i].p >= c) dp[c] = Math.min(dp[c], dp[j] + arr[i].cost);
                    else dp[j+arr[i].p] = Math.min(dp[j+arr[i].p], dp[j] + arr[i].cost);
                }
            }
        }

        System.out.println(dp[c]);
    }
}