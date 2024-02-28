import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        StringBuilder br = new StringBuilder();
        String n = sc.next();
        Integer[] arr = new Integer[n.length()];
        for(int i=0;i<n.length();i++) {
            arr[i] = n.charAt(i) - '0';
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<n.length();i++) {
            br.append(arr[i]);
        }

        String str = br.toString();
        System.out.println(str);

    }
}