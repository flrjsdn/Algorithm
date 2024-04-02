import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for(int tc=0;tc < testCase; tc++) {
            boolean check = false;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            for(int i=x;i<(n*m);i+= m) {
                if(i%n == y) {
                    System.out.println(i+1);
                    check = true;
                    break;
                }
            }
            if(!check) {
                System.out.println(-1);
            }


        }
    }
}