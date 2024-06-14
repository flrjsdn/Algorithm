import java.io.*;
import java.util.*;
public class Main {
    public static int n;
    public static int[] calArr, numArr;
    public static boolean[] visited;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;

    public static void dfs(int depth, int sum) {
        if(depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for(int i=0;i<4;i++) {
            if(calArr[i] != 0) {
                calArr[i] -= 1;
                dfs(depth+1, func(numArr[depth], i,sum));
                calArr[i] += 1;
            }
        }
    }

    public static int func(int num, int index, int sum) {
        if(index == 0) sum += num;
        else if(index==1) sum -= num;
        else if(index==2) sum *= num;
        else sum /= num;
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        calArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<4;i++) {
            calArr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(1,numArr[0]);
        System.out.println(max);
        System.out.println(min);

    }
}