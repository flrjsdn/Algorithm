import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static boolean[] visited = new boolean[9];
    public static int[] arr;

    public static void dfs(int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(n,m,0);

    }
}