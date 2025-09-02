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

    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static void dfs(int num, int cnt) {
        cnt += calOddNum(num);
        if(num / 10 == 0) {
            max = Math.max(max, cnt);
            min = Math.min(min, cnt);
            return;
        } else if(num / 100 == 0) {
            int next = num / 10;
            next += num % 10;
            dfs(next, cnt);
        } else {
            String s = String.valueOf(num);
            for(int i=0;i<s.length() - 2;i++) {
                for(int j=i+1;j<s.length() - 1; j++) {
                    int next = Integer.parseInt(s.substring(0,i+1));
                    next += Integer.parseInt(s.substring(i+1,j+1));
                    next += Integer.parseInt(s.substring(j+1));

                    dfs(next,cnt);
                }
            }
        }
    }

    static int calOddNum(int num) {
        int cnt = 0;
        while(num > 0) {
            int tmp = num % 10;
            if(tmp % 2 == 1) cnt++;
            num /= 10;
        }

        return cnt;
    }
    public static void main(String[] args) throws Exception {
        N = read();
        dfs(N,0);
        System.out.println(min + " " + max);
    }
}