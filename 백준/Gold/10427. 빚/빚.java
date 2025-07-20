import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        
        for(int tc=1;tc<=T;tc++) {
            int n = read();
            long[] s = new long[n+1];
            s[1] = 0;
            long[] borrow = new long[n+1];
            for(int i=1;i<=n;i++) {
                borrow[i] = read();
            }
            Arrays.sort(borrow);
            for(int i=1;i<=n;i++) {
                borrow[i] += borrow[i-1];
            }

            long ans = 0;
            for(int i=2;i<=n;i++) {
                long min = Long.MAX_VALUE;
                for(int j=i;j<=n;j++) {
                    long now = borrow[j] - borrow[j-1];
                    long sum = i*now - (borrow[j] - borrow[j-i]);
                    min = Math.min(min, sum);
                }
                ans += min;
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}