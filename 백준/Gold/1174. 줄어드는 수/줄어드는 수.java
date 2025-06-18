import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> arrList = new ArrayList<>();
    static int n;

    static void dfs(long num, int index) {
        if(!arrList.contains(num)) arrList.add(num);

        if(index >= 10) return;

        dfs((num*10) + arr[index], index+1);
        dfs(num, index+1);
    }

    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0,0);
        Collections.sort(arrList);

        if(n > arrList.size()) System.out.println(-1);
        else System.out.println(arrList.get(n-1));
    }
}