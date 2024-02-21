import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int[] arr = {-1,-1,-1};
        while(true) {
            for(int i=0;i<3;i++) {
                arr[i] = sc.nextInt();
            }
            if(arr[0] ==0 && arr[1] == 0 && arr[2] == 0) break;
            Arrays.sort(arr);
            if(arr[2] >= arr[0]+arr[1]) {
                System.out.println("Invalid");
            }
            else {
                if (arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2]) System.out.println("Equilateral");
                else if (arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]) System.out.println("Scalene");
                else System.out.println("Isosceles");
            }
        }
    }
}