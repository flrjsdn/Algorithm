import java.io.*;
import java.util.*;

public class Main {
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while(start < end) {
            int mid = (start + end) /2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1;

            if(arr[mid] == target) return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] result = new int[m];
        for(int i=0;i<m;i++) {
            result[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i=0;i<m;i++) {
            System.out.print(binarySearch(arr, result[i], 0, n) + " ");
        }
    }
}