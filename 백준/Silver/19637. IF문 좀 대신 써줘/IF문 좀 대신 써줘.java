import java.io.*;
import java.util.*;
public class Main {
    public static int n,m;
    public static void binarySearch(String[] name, int[] score, int target) {
        int start = 0;
        int end = n-1;
        int mid = 0;
        while(start <= end) {
            mid = (start+end) / 2;
            if(score[mid] < target) start = mid+1;
            else end = mid-1;
        }
        System.out.println(name[start]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String[] name = new String[n];
        int[] score = new int[n];
        int[] scoreList = new int[m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<m;i++) {
            scoreList[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0;i<m;i++) {
            binarySearch(name, score, scoreList[i]);
        }
    }
}