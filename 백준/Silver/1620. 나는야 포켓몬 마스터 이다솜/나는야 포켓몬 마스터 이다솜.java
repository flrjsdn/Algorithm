import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for(int i=1;i<=n;i++) {
            String s = sc.next();
            map.put(i, s);
            map2.put(s, i);
        }

        for(int i=0;i<m;i++) {
            String str = sc.next();
            int num = str.charAt(0) - '0';
            if(num >= 0 && num <= 9)  sb.append(map.get(Integer.parseInt(str))).append('\n');
            else sb.append(map2.get(str)).append('\n');
        }
        System.out.println(sb);

    }
}