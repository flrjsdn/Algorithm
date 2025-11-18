import java.util.*;
import java.lang.*;
import java.io.*;

class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
	public static void main (String[] args) throws java.lang.Exception
	{
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
		    st = new StringTokenizer(br.readLine());
		    double num = Double.parseDouble(st.nextToken());
		    while(true) {
		        if(!st.hasMoreTokens()) break;
		        String next = st.nextToken();
		        if(next.equals("@")) num *= 3;
		        else if(next.equals("%")) num += 5;
		        else num -= 7;
		    }
		    sb.append(String.format("%.2f", num) + "\n");
		}
		System.out.println(sb);

	}
}