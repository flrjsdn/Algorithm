import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        while(true) {
            int n = sc.nextInt();
            if(n == -1) break;
            int sum = 0;
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=1;i<n;i++) {
                if(n%i == 0) {
                    arr.add(i);
                    sum += i;
                }
            }

            if(sum == n) {
                System.out.print(n + " = ");
                for(int i=0;i<arr.size();i++) {
                    if(i == arr.size()-1) System.out.print(arr.get(i));
                    else System.out.print(arr.get(i) + " + ");
                }
                System.out.println();
            }
            else{
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}