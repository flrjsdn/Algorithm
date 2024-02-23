import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        
        ArrayList<Integer> graph = new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(sc.nextInt());
        }

        Collections.sort(graph);
        for(int value:graph){
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}