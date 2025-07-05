import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int n;
    static char[] ans;
    static boolean solved = false;

    static void findNum(int depth) {
        if(solved) return;
        
        if(depth == n) {
            System.out.println(new String(ans));
            solved = true;
            return;
        }

        for(char c = '1'; c<='3';c++) {
            ans[depth] = c;
            if(check(depth+1)) {
                findNum(depth+1);
                if(solved) return;
            }
        }
    }

    static boolean check(int len) {
        for(int i=1;i*2<=len;i++) {
            for(int j=0;j+i*2<=len;j++) {
                boolean flag = true;
                for(int k=0;k<i;k++) {
                    if(ans[j+k] != ans[j+i+k]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new char[n];
        findNum(0);
    }
}