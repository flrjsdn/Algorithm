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
    static int n;
    static int[] arr;
    
    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = read();
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int start = 0;
                int end = arr.length - 1;
                int snow = arr[i] + arr[j];
                while(start < end) {
                    if(start == i || start==j) {
                        start++;
                        continue;
                    }
                    if(end == j || end ==i) {
                        end--;
                        continue;
                    }
                    int sum = arr[start] + arr[end];
                    ans = Math.min(ans, Math.abs(sum-snow));
                    if(snow > sum) start++;
                    else end--;
                }
            }
        }
        System.out.println(ans);
    }
}