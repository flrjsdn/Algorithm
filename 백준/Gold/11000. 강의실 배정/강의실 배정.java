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

    static class Class implements Comparable<Class>{
        int start;
        int end;

        public Class(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Class other) {
            if(this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }

            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) throws Exception {
        int N = read();
        Class[] c = new Class[N];
        for(int i=0;i<N;i++) {
            c[i] = new Class(read(), read());
        }

        Arrays.sort(c);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(c[0].end);

        for(int i=1;i<N;i++) {
            if(pq.peek() <= c[i].start) pq.poll();

            pq.add(c[i].end);
        }
        System.out.println(pq.size());
    }
}