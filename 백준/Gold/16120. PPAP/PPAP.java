import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            stack.add(c);

            if(stack.size() >= 4) {
                String tmp = "";
                for(int j=0;j<4;j++) {
                    tmp = stack.pop() + tmp;
                }

                if(tmp.equals("PPAP")) stack.add('P');
                else {
                    for(int j=0;j<4;j++) {
                        stack.add(tmp.charAt(j));
                    }
                }
            }
        }

        if(stack.size() == 1 && stack.peek()=='P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}