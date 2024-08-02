import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			StringTokenizer st;
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String type = st.nextToken();
				
				map.put(type, map.getOrDefault(type, 0) + 1);
				
			}
			int result = 1;
			for(int val : map.values()) {
				result *= (val+1);
			}
			System.out.println(result-1);
		}
    }
}