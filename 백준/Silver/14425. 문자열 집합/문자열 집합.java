import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int cnt = 0;
        sc.nextLine();
        String[] arr = new String[n];
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<n;i++) {
            set.add(sc.nextLine());
        }
        for(int i=0;i<m;i++) {
            String str = sc.nextLine();
            if(set.contains(str)) cnt += 1;
        }
        System.out.println(cnt);
    }
}