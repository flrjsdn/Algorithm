import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r+1][c+1];
    
        for(int i=1;i<=r;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1;j<=c;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		arr[i][j] += arr[i][j-1];
        	}
        }
        
        for(int i=0;i<q;i++) {
        	st = new StringTokenizer(br.readLine());
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	int x2 = Integer.parseInt(st.nextToken());
        	int y2 = Integer.parseInt(st.nextToken());
        	int size = (x2-x1+1) * (y2-y1+1);
        	int result = 0;
        	for(int j = x1; j<=x2;j++) {
        		result += arr[j][y2] - arr[j][y1-1];
        	}
        	System.out.println(result/size);
        }
    }
}