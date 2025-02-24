import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws IOException {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}
	
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		String c = st.nextToken();
		long sum = 0;
		if(a.equals("?")) {
			sum = (int) (Math.pow(Long.parseLong(c), 2) - Math.pow(Long.parseLong(b), 2));
		} else if(b.equals("?")) {
			sum = (long) (Math.pow(Long.parseLong(c), 2) - Math.pow(Long.parseLong(a), 2));
		} else {
			sum = (long) (Math.pow(Long.parseLong(a), 2) + Math.pow(Long.parseLong(b), 2));
		}
		
		long k = 1;
        for (long i = 1; i * i <= sum; i++) {
            if(sum % (i * i) == 0) {
                k = i;
            }
        }
        long d = sum / (k * k);
        
  
        if(d == 1) {
            System.out.println(k);
        } else {
            if(k == 1) {
                System.out.println("\\sqrt{" + d + "}");
            } else {
                System.out.println(k + " \\cdot \\sqrt{" + d + "}");
            }
        }
	}
}
