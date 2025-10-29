import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws IOException {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int N;
    public static void main(String[] args) throws IOException {
        N = read();
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = read();
        }

        TreeSet<Integer> set = new TreeSet<>();
        set.add(arr[1]);
        int ans = 1;
        for(int i=2;i<=N;i++) {
            int now = arr[i];
            if(now > set.last()) {
                set.add(now);
                continue;
            }

            int check = set.ceiling(now);
            set.remove(check);
            set.add(now);
        }
        System.out.println(set.size());
    }
}