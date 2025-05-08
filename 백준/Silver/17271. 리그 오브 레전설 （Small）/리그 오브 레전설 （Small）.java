import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        arr[0] = 1;
        for(int i=1;i<=n;i++) {
            if(i-m>=0) arr[i] = (arr[i] + arr[i-m]) % MOD;
            arr[i] = (arr[i] + arr[i-1]) % MOD;
        }
        System.out.println(arr[n] % MOD);
    }
}