import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static class Tire implements Comparable<Tire>{
        int s;
        int p;

        public Tire(int s,int p) {
            this.s = s;
            this.p = p;
        }

        @Override
        public int compareTo(Tire other) {
            return Integer.compare(this.p, other.p);
        }
    }
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int n,m, total;
    static int[] dp;
    static ArrayList<Tire> arr;
    
    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new ArrayList<>();
        total = 0;
        for(int i=0;i<n;i++) {
            int a = read();
            int b = read();
            arr.add(new Tire(a,b));
            total += a;
        }
        dp = new int[m+1];
        Arrays.fill(dp, -total);

        for(int i=0;i<n;i++) {
            Tire now = arr.get(i);
            for(int j=1;j<=m;j++) {
                if(j >= now.p) {
                    dp[j] = Math.max(dp[j], dp[j-now.p] + now.s);
                }

                if(j >= now.p + 1) {
                    dp[j] = Math.max(dp[j], dp[j-now.p + 1] + now.s*2);
                }
            }
        }
        if(dp[m] > 0) System.out.println("W");
        else if(dp[m] == 0) System.out.println("D");
        else System.out.println("L");
    }
}