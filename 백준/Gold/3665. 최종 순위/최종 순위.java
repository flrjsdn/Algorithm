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

    static int N,M;
    static int[] indegree;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        int T = read();
        StringBuilder sb = new StringBuilder();
        s : for(int tc=0;tc<T;tc++) {
            N = read();
            graph = new ArrayList[N+1];
            for(int i=0;i<=N;i++) {
                graph[i] = new ArrayList<>();
            }
            
            indegree = new int[N+1];
            List<Integer> before = new ArrayList<>();
            
            int add = 0;
            for(int i=1;i<=N;i++) {
                int num = read();
                indegree[num] = add++;
                for(int next : before) {
                    graph[next].add(num);
                }
                before.add(num);
            }

            M = read();
            for(int i=0;i<M;i++) {
                int a = read();
                int b = read();
                if(graph[a].contains(b)) {
                    indegree[a]++; indegree[b]--;
                    graph[a].remove((Integer)b);
                    graph[b].add(a);
                } else {
                    indegree[a]--; indegree[b]++;
                    graph[b].remove((Integer)a);
                    graph[a].add(b);
                }
            }

            Queue<Integer> q = new ArrayDeque<>();
            for(int i=1;i<=N;i++) {
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> ans = new ArrayList<>();
            while(!q.isEmpty()) {
                int now = q.poll();

                ans.add(now);
                for(int next : graph[now]) {
                    indegree[next]--;
                    if(indegree[next] == 0) {
                        q.add(next);
                    }
                }
            }

            for(int i=1;i<=N;i++) {
                if(indegree[i] != 0) {
                    sb.append("IMPOSSIBLE\n");
                    continue s;
                }
            }

            for(int next : ans) {
                sb.append(next + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}