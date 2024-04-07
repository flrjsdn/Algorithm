import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static boolean[] visited;
    public static int[] arr;
    public static int[] result;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int index, int depth) {
        if (depth == m) {
            for(int i=0;i<m;i++) {
                sb.append(result[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=index;i<n;i++) {
            result[depth] = arr[i];
            dfs(index, depth+1);
            }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        result = new int[m];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.print(sb);

    }
}