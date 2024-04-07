import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static boolean[] visited = new boolean[9];
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++) {
            arr[depth] = i;
            dfs(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(0);
        System.out.print(sb);

    }
}