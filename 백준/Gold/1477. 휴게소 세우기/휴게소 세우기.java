import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr;
    static int n,m,l;
    static int ans;

    static void binarySearch(int start, int end) {
        while(start <= end) {
            int mid = (start+end) / 2;
            if(check(mid)) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        ans = start;
    }

    static boolean check(int num) {
        int cnt = 0;
        for(int i=0;i<=n;i++) {
            int gap = arr[i+1] - arr[i];
            if(gap > num) {
                if(gap % num == 0) cnt += (gap/num) -1;
                else cnt += (gap/num);
            }
        }
        if(cnt <= m) return true;
        else return false;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        if(n==0) {
            ans = l/(m+1);
            if(l % (m+1) != 0) ans += 1;
            System.out.println(ans);
        } else {
            arr = new int[n+2];
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr[n+1] = l;
            Arrays.sort(arr);

            ans = 0;
            binarySearch(1, l);
            System.out.println(ans);
        }
    }
}