import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[][] jMap = new int[m+1][n+1];
        int[][] oMap = new int[m+1][n+1];
        int[][] iMap = new int[m+1][n+1];

        for(int i=0;i<m;i++) {
            String s = br.readLine();
            for(int j=0;j<n;j++) {
                char c = s.charAt(j);
                if(c == 'J') {
                    jMap[i+1][j+1] = jMap[i+1][j] + jMap[i][j+1] - jMap[i][j] + 1;
                    oMap[i+1][j+1] = oMap[i+1][j] + oMap[i][j+1] - oMap[i][j];
                    iMap[i+1][j+1] = iMap[i+1][j] + iMap[i][j+1] - iMap[i][j];
                }else if(c == 'O') {
                    jMap[i+1][j+1] = jMap[i+1][j] + jMap[i][j+1] - jMap[i][j];
                    oMap[i+1][j+1] = oMap[i+1][j] + oMap[i][j+1] - oMap[i][j] + 1;
                    iMap[i+1][j+1] = iMap[i+1][j] + iMap[i][j+1] - iMap[i][j];
                } else {
                    jMap[i+1][j+1] = jMap[i+1][j] + jMap[i][j+1] - jMap[i][j];
                    oMap[i+1][j+1] = oMap[i+1][j] + oMap[i][j+1] - oMap[i][j];
                    iMap[i+1][j+1] = iMap[i+1][j] + iMap[i][j+1] - iMap[i][j] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int jArea = jMap[x2][y2] - jMap[x2][y1-1] - jMap[x1-1][y2] + jMap[x1-1][y1-1];
            int oArea = oMap[x2][y2] - oMap[x2][y1-1] - oMap[x1-1][y2] + oMap[x1-1][y1-1];
            int iArea = iMap[x2][y2] - iMap[x2][y1-1] - iMap[x1-1][y2] + iMap[x1-1][y1-1];
            sb.append(jArea + " ").append(oArea + " ").append(iArea + "\n");
        }
        System.out.println(sb);
    }
}