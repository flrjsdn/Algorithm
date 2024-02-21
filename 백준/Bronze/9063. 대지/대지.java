import java.io.*;
import java.util.*;
public class Main {
    public static int n;

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] xArr = new int[n];
        int[] yArr = new int[n];
        for(int i=0;i<n;i++) {
            xArr[i] = sc.nextInt();
            yArr[i] = sc.nextInt();
        }

        Arrays.sort(xArr);
        Arrays.sort(yArr);

        int result = (xArr[n-1] - xArr[0]) * (yArr[n-1] - yArr[0]);

        System.out.println(result);
    }
}