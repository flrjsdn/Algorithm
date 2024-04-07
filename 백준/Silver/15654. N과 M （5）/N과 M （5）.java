import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static boolean[] visited;
    public static int[] arr;
    public static ArrayList<Integer> graph;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int index, int depth) {
        if (depth == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=index;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = graph.get(i);
                dfs(index, depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];
        graph = new ArrayList<Integer>();
        for(int i=0;i<n;i++) {
            graph.add(sc.nextInt());
        }
        Collections.sort(graph);
        dfs(0, 0);
        System.out.print(sb);

    }
}