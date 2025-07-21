import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);
            int cnt = 0;
            int ans = Integer.MAX_VALUE;
            int start = 0;
            int end = n-1;
            while(start < end) {
                int sum = arr[start] + arr[end];
                int diff = Math.abs(k-sum);
                if(diff < ans) {
                    ans = diff;
                    cnt = 1;
                }else if(diff == ans) {
                    cnt++;
                }
                if(sum > k) end -= 1;
                else if(sum == k) {
                    start += 1;
                    end -= 1;
                }
                else start += 1;
            }

            System.out.println(cnt);
        }
    }
}