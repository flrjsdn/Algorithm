import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt();
        String[] str = new String[n];

        for(int i=0;i<n;i++) {
            str[i] = sc.next();
        }

        Arrays.sort(str, (e1,e2) ->{
            if(e1.length() == e2.length()){
                return e1.compareTo(e2);
            }
            else{
                return e1.length() - e2.length();
            }
        });
        System.out.println(str[0]);

        for(int i=1;i<n;i++) {
            if(!str[i].equals(str[i-1])){
                System.out.println(str[i]);
            }
        }

    }
}