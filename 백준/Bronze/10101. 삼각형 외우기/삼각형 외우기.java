import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a+b+c == 180) {
            if(a == 60 && b == 60 && c == 60) System.out.println("Equilateral");
            else if(a != b && b != c && a != c) System.out.println("Scalene");
            else System.out.println("Isosceles");
        }
        else {
            System.out.println("Error");
        }
    }
}