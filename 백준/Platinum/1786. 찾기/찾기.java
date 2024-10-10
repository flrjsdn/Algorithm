import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
    	if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
    	return Integer.parseInt(st.nextToken());
    }
    
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    static int[] makeTable(String pattern) {
    	int n = pattern.length();
    	int[] table = new int[n];
    		
    	int idx=0;
    	for(int i=1; i<n; i++) {
            // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
    		while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
    			idx = table[idx-1];
    		}
    			
    		if(pattern.charAt(i) == pattern.charAt(idx)) {
    			idx += 1;
    			table[i] = idx;  
    		}
    	}
    	return table;
    }
    
    static void KMP(String parent, String pattern) {
    	int[] table = makeTable(pattern); //테이블 생성
    		
    	int n1 = parent.length();
    	int n2 = pattern.length();
    		
    	int idx = 0; // 현재 대응되는 글자 수
    	for(int i=0; i< n1; i++) {
    		// idx번 글자와 짚더미의 해당 글자가 불일치할 경우, 
    		// 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
    		while(idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
    			idx = table[idx-1];
    		}
    		// 글자가 대응될 경우	
    		if(parent.charAt(i) == pattern.charAt(idx)) {
    			if(idx == n2-1) {
    				sb.append(i-idx+1).append(" ");
    				cnt++;
    				idx =table[idx];
    			}else {
    				idx += 1;
    			}
    		}
    	}
    }
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        String pattern = br.readLine();
        cnt = 0;
        KMP(str, pattern);
        System.out.println(cnt);
        System.out.println(sb);
    }
}