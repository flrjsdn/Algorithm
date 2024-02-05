import java.io.*;
import java.util.*;

public class Main {

    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=1;i<n+1;i++) {
            if(n%i == 0){
                arr.add(i);
            }
        }

        if(arr.size() < k){
            System.out.println(0);
        }
        else{
            System.out.println(arr.get(k-1));
        }
    }
}