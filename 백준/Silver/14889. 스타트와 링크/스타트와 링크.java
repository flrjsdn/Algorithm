import java.io.*;
import java.util.*;

public class Main {
    public static int n, min = Integer.MAX_VALUE;
    public static int[][] arr = new int[20][20];
    public static boolean[] visited = new boolean[20];

    public static void dfs(int depth, int idx) {
        if(depth == n / 2) {
            diff();
            return;
        }

        for(int i=idx;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    public static void diff(){
        int teamStart = 0;
        int teamLink = 0;

        for(int i=0;i<n-1;i++) {
            for(int j = i+1;j<n;j++) {
                if(visited[i] == true && visited[j] == true) {
                    teamStart += arr[i][j];
                    teamStart += arr[j][i];
                }
                else if(visited[i] == false && visited[j] == false){
                    teamLink += arr[i][j];
                    teamLink += arr[j][i];
                }
            }
        }
        int val = Math.abs(teamStart - teamLink);
        min = Math.min(val, min);
    }
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);
        System.out.println(min);
    }
}