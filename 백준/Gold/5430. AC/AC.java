import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			ArrayDeque<String> dq = new ArrayDeque<>();
			String s = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String nList = br.readLine();
			String[] sList = nList.substring(1,nList.length()-1).split(",");
			for(String next : sList) {
				if(next.equals("")) continue;
				dq.add(next);
			}
			
			int isFront = 1;
			boolean isError = false;
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == 'R') {
					isFront *= -1; 
				}else {
					if(dq.isEmpty()) {
						sb.append("error\n");
						isError = true;
						break;
					}else {
						if(isFront== 1) {
							dq.pollFirst();
						}else {
							dq.pollLast();
						}
					}
				}
			}
			
			if(!isError) {
				sb.append("[");
				if(isFront == 1) {
					while(dq.size() > 1) {
						sb.append(dq.pollFirst() + ",");
					}
				}else {
					while(dq.size() > 1) {
						sb.append(dq.pollLast() + ",");
					}
				}
				if(!dq.isEmpty()) sb.append(dq.poll() + "]\n");
				else sb.append("]\n");
			}
		}
		System.out.println(sb);
    }
}
