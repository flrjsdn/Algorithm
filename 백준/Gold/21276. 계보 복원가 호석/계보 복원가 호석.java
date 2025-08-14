import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int N, M;
    static HashMap<String, Integer> indegrees = new HashMap<>();
    static HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
    static TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            String s = st.nextToken();
            map.put(s, new ArrayList<>());
            graph.put(s, new ArrayList<>());
            indegrees.put(s, 0);
        }

        M = Integer.parseInt(br.readLine());
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            graph.get(parent).add(child);
            indegrees.put(child, indegrees.getOrDefault(child, 0) + 1);
        }


        ArrayList<String> pre = new ArrayList<>();
        Queue<String> q = new ArrayDeque<>();
        for(String key : indegrees.keySet()) {
            int in = indegrees.get(key);
            if(in == 0) {
                q.add(key);
                pre.add(key);
            }
        }

        while(!q.isEmpty()) {
            String now = q.poll();
            
            for(String next : graph.get(now)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if(indegrees.get(next) == 0) {
                    q.add(next);
                    map.get(now).add(next);
                }
            }
        }

        Collections.sort(pre);
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pre.size() + "\n");
        for(String s : pre) {
            sb.append(s + " ");
        }
        sb.append("\n");

        for(String key : map.keySet()) {
            sb.append(key + " " + map.get(key).size() + " ");
            for(String child : map.get(key)) sb.append(child + " ");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}