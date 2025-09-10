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

    static class Query implements Comparable<Query> {
        int start;
        int end;
        int w;

        public Query(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(Query other) {
            if(this.end == other.end) return Integer.compare(this.start, other.start);
            return Integer.compare(other.end, this.end);
        }
    }

    static int N, Q;
    public static void main(String[] args) throws Exception {
        N = read();
        Q = read();
        List<Query> qList = new ArrayList<>();
        int max = 0;
        for(int i=0;i<Q;i++) {
            int s = read();
            int e = read();
            int w = read();
            qList.add(new Query(s,e,w));
            max = Math.max(e, max);
        }

        int[] ans = new int[N+1];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<=max;i++) {
            set.add(i);
        }

        for(Query q : qList) {
            int s = q.start;
            int now = set.floor(q.end);
            while(true) {
                if(now < s) break;
                ans[now] = q.w;
                set.remove(now);
                now = set.floor(now-1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N;i++) {
            sb.append(ans[i] + " ");
        }
        System.out.println(sb);
    }
}