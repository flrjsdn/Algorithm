import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        
        for(int i=0;i<n;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<m;j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int[] index = new int[n];
        for(int i=0;i<n;i++) {
        	Arrays.sort(arr[i]);
        	index[i] = 0;
        }
        int min = Integer.MAX_VALUE;
        while(true) {
        	int sMin = arr[0][index[0]];
        	int sMax = arr[0][index[0]];
        	int minIndex = 0;
        	for(int i=1;i<n;i++) {
        		if(sMin > arr[i][index[i]]) {
        			sMin = arr[i][index[i]];
        			minIndex = i;
        		}
        		if(sMax < arr[i][index[i]]) {
        			sMax = arr[i][index[i]];
        		}
        	}
        	if((sMax - sMin) < min) {
        		min = sMax - sMin;
        	}
    
        	if(++index[minIndex] >= m) break;
        }
        System.out.println(min);
    }
}