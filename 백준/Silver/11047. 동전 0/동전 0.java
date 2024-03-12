import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int count = 0;

        for(int num : arr) {
            if((k / num) != 0) {
                count += (k/num);
                k %= num;
            }
        }

        System.out.println(count);
    }
}