import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int length, ans;
    static char[] arr;
    static int[] numList;
    static boolean[] visited;
    
    static void dfs(int sum, int index) {
        if(index >= arr.length) {
            ans = Math.max(ans, sum);
            return;
        }

        int res1 = cal(arr[index], sum, numList[index+1]);
        dfs(res1, index+1);

        if(index+1 < arr.length) {
            int res2 = cal(arr[index+1], numList[index+1], numList[index+2]);
            dfs(cal(arr[index], sum, res2), index+2);
        }
    }

    static int cal(char c, int a, int b) {
        switch(c) {
            case '+' :
                return a + b;
            
            case '-' :
                return a-b;

            case '*' :
                return a*b;
        }
        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        length = s.length()/2;
        visited = new boolean[length];
        numList = new int[length + 1];
        arr = new char[length];
        for(int i=0;i<s.length();i++) {
            if(i % 2 == 0) numList[i/2] = s.charAt(i) - '0';
            else arr[i/2] = s.charAt(i);
        }

        ans = Integer.MIN_VALUE;
        dfs(numList[0], 0);
        System.out.println(ans);
    }
}