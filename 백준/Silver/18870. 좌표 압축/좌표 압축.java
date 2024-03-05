import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sorted = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sorted[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        Arrays.sort(sorted);

        int rank = 0;
        for(int v: sorted) {
            if(!rankingMap.containsKey(v)) {
                rankingMap.put(v,rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int key : arr) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}