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
    static int[] arr;
    public static void main(String[] args) throws Exception {
        N = read();
        arr = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = read();
        }

        boolean odd = true;
        boolean even = true;

        int evenMax = arr[0];
        for(int i=1;i<N;i++) {
            evenMax = Math.max(evenMax, arr[i]);
            if(arr[i-1] > arr[i]) {
                if(arr[i-1] % 2 == 0 && arr[i] % 2 == 0) {
                    even = false;
                    break;
                }
                if(arr[i-1] % 2 == 1 && arr[i] % 2 == 1) {
                    even = false;
                    break;
                }
            }
        }

        int oddMax = arr[0];
        for(int i=1;i<N;i++) {
            oddMax = Math.max(oddMax, arr[i]);

            if(arr[i-1] > arr[i]) {
                if(arr[i-1] % 2 == 1 && arr[i] % 2 == 0) {
                    odd = false;
                    break;
                }

                if(arr[i-1] % 2 == 0 && arr[i] % 2 == 1) {
                    odd = false;
                    break;
                }
            }
        }
        

        StringBuilder sb = new StringBuilder();
        if(even) sb.append("So Lucky\n");
        else sb.append("Unlucky\n");

        if(odd) sb.append("So Lucky\n");
        else sb.append("Unlucky\n");
        System.out.println(sb);
    }
}