import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;
    static final int SIZE = 99_999;
    static TreeSet<Integer>[] xSet = new TreeSet[2*SIZE + 100];
    static TreeSet<Integer>[] ySet = new TreeSet[2*SIZE + 100];
    
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<2*SIZE+100;i++) {
            xSet[i] = new TreeSet<>();
            ySet[i] = new TreeSet<>();
        }
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xSet[SIZE+x].add(SIZE+y);
            ySet[SIZE+y].add(SIZE+x);
        }

        String s = br.readLine();
        int nowX = SIZE;
        int nowY = SIZE;
        for(int i=0;i<s.length();i++) {
            switch(s.charAt(i)) {
                case 'R' :
                    nowX = ySet[nowY].higher(nowX);
                    break;
                case 'L' :
                    nowX = ySet[nowY].lower(nowX);
                    break;
                case 'U' :
                    nowY = xSet[nowX].higher(nowY);
                    break;
                case 'D' :
                    nowY = xSet[nowX].lower(nowY);
                    break;
            }
        }
        System.out.println((nowX - SIZE) + " " + (nowY - SIZE));
    }
}