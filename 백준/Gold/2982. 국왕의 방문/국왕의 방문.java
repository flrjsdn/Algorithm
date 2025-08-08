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

    static void dijk() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        dist[A] = K;
        pq.add(new int[] {A,K});

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            for(Map.Entry<Integer, Integer> e : map[now[0]].entrySet()) {
                int to = e.getKey();
                int value = e.getValue();

                int arriveTime = now[1];
                Integer start = block[now[0]].get(to);
                if(start != null && start <= arriveTime) {
                    arriveTime = Math.max(arriveTime, start+value);
                }
                arriveTime += value;

                if(arriveTime < dist[to]) {
                    dist[to] = arriveTime;
                    pq.add(new int[] {to, arriveTime});
                }
            }
        }
    }

    static int N,M;
    static int A,B,K,G;
    static final int INF = (int)1e9;
    static int[] dist;
    static HashMap<Integer, Integer>[] map;
    static HashMap<Integer, Integer>[] block;
    public static void main(String[] args) throws Exception {
        N = read(); M = read();
        A = read(); B = read(); K = read(); G = read();
        map = new HashMap[N+1];
        block = new HashMap[N+1];
        for(int i=0;i<=N;i++) {
            map[i] = new HashMap<>();
            block[i] = new HashMap<>();
        }
        
        int[] step = new int[G];
        for(int i=0;i<G;i++) {
            step[i] = read();
        }

        for(int i=0;i<M;i++) {
            int a = read();
            int b = read();
            int c = read();
            map[a].put(b,c);
            map[b].put(a,c);
        }

        int start = step[0];
        int end = 0;
        int t = 0;
        for(int i=1;i<G;i++) {
            end = step[i];
            int distance = map[start].get(end);
            block[start].put(end, t);
            block[end].put(start, t);
            t += distance;
            start = end;
        }

        dist = new int[N+1];
        Arrays.fill(dist, INF);
        dijk();
        System.out.println(dist[B] - K);
    }
}