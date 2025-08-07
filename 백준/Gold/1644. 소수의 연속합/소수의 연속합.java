import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static ArrayList<Integer> graph = new ArrayList<>();

    static void calPrime(int num) {
        for(int i=2;i<=num;i++) {
            if(prime(i)) graph.add(i);
        }
    }
    
    static boolean prime(int num) {
        for(int i=2;i<=(int) Math.sqrt(num);i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        calPrime(n);
        int[] arr = new int[graph.size()+1];
        for(int i=0;i<graph.size();i++) {
            arr[i+1] = graph.get(i);
            arr[i+1] += arr[i];
        }

        int start = 0;
        int end = 1;
        int ans = 0;
        while(start < end && end < graph.size() + 1) {
            int sum = arr[end] - arr[start];
            if(sum == n) {
                ans++;
                start++;
                end++;
            }
            else if(sum > n) start++;
            else if(sum < n) end++;
        }
        System.out.println(ans);
    }
}