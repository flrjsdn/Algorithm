import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[20000001];
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<String> map = new HashSet<>();
        for(int i=0;i<n;i++) {
            map.add(sc.next());
        }

        int count = 0;
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<m;i++) {
            String str = sc.next();
            if(map.contains(str)) {
                count++;
                arr.add(str);
            }
        }
        Collections.sort(arr);
        System.out.println(count);

        for(int i=0;i<arr.size();i++) {
            System.out.println(arr.get(i));
        }

    }
}