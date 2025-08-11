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
    static int[] card;
    
    public static void main(String[] args) throws Exception {
        N = read();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++) {
            pq.add(read());
        }

        int ans = 0;
        while(!pq.isEmpty()) {
            if(pq.size() < 2) break;
            int a = pq.poll();
            int b = pq.poll();
            ans += (a+b);
            pq.add(a+b);
        }
        System.out.println(ans);
    }
}