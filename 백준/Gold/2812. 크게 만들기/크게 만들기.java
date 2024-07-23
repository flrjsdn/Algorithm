import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int len = n-k;
        
        Stack<Character> stack = new Stack<>();
        Deque<Character> dq = new ArrayDeque<>();
        
        char[] str = br.readLine().toCharArray();

        //stack 버전
        for(int i = 0; i <str.length; i++){
        	while(!stack.empty() && k > 0 && stack.peek() < str[i]){
                stack.pop();
                k--;
            }
            stack.push(str[i]);
        }
        
       
        while(k>0 && stack.size() != len) {
        	stack.pop();
        	k--;
        }
        
        for(char c : stack) {
        	sb.append(c);
        }
        
        System.out.println(sb);
        
        //Deque 버전
//        for(int i=0;i<str.length;i++) {
//        	while(!dq.isEmpty() && k>0 && dq.peekLast() < str[i]) {
//        		dq.removeLast();
//        		k--;
//        	}
//        	dq.addLast(str[i]);
//        }
//        
//        while(dq.size() > k) {
//        	sb.append(dq.removeFirst());
//        }
//
//        System.out.println(sb);
        
    }
}