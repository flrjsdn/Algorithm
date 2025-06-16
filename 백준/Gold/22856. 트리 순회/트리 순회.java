import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static class Node {
        public int left;
        public int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    static boolean[] visited;
    static int answer, lastNode;
    static Node[] graph;
    static boolean flag;

    static void init(int node) {
        if(graph[node].left != -1) {
            init(graph[node].left);
        }

        lastNode = node;

        if(graph[node].right != -1) {
            init(graph[node].right);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        int left = graph[node].left;
        int right = graph[node].right;
        if(left != -1 && !visited[left]) {
            dfs(left);
            answer++;
        }

        if(right != -1 && !visited[right]) {
            dfs(right);
            answer++;
        }

        if(node == lastNode) {
            flag = true;
            return;
        }
        if(flag) return;
        answer++;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        graph = new Node[n+1];
        
        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p] = new Node(l,r);
        }

        answer = 0;
        init(1);
        dfs(1);
        System.out.println(answer);
    }
}