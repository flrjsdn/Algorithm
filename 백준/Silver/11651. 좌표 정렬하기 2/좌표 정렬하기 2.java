import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (e1,e2) ->{
            if(e1[1] == e2[1]) {
                return e1[0]-e2[0];
            }
            else{
                return e1[1] - e2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }
        System.out.println(sb);

    }
}