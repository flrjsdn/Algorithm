import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	String[] str = sc.next().split("-");
    	
    	ArrayList<Integer> result = new ArrayList<>();
    	for(int i=0;i<str.length;i++) {
    		String[] s = str[i].split("\\+");
    		int sum = 0;
    		for(int j=0;j<s.length;j++) {
    			sum += Integer.parseInt(s[j]);
    		}
    		result.add(sum);
    	}
    	int total = result.get(0);
    	for(int i=1;i<result.size();i++) {
    		total -= result.get(i);
    	}
    	System.out.println(total);
    }
}
