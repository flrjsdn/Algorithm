import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[20000001];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<n;i++) {
            arr[Integer.parseInt(st.nextToken())+10000000]++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
        }
        System.out.println(sb.toString());
    }
}