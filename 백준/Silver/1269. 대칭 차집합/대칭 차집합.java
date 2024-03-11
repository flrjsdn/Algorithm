import java.io.*;
import java.util.*;

public class Main {
    public static int[] arr = new int[20000001];
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        HashSet<Integer> aMap = new HashSet<>();
        HashSet<Integer> bMap = new HashSet<>();
        for(int i=0;i<a;i++) {
            aMap.add(sc.nextInt());
        }
        for(int i=0;i<b;i++) {
            bMap.add(sc.nextInt());
        }

        int count = 0;
        for(int num : aMap) {
            if(!bMap.contains(num)) count++;
        }
        for(int num : bMap) {
            if(!aMap.contains(num)) count++;
        }
        System.out.println(count);
    }
}