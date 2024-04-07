import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static boolean[] visited = new boolean[9];
    public static int[] arr;

    public static void dfs(int N, int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = N; i <= n; i++) {
            arr[depth] = i;
            dfs(i+1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        dfs(1,0);

    }
}