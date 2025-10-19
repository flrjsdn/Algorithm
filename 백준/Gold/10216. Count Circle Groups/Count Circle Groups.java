import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws IOException {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static class Pos {
        int x;
        int y;
        int w;

        public Pos(int x,int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    static int N;
    static int[] parent;

    static int findParent(int num) {
        if(parent[num] == num) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    static double calDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
    }
    public static void main(String[] args) throws IOException {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++) {
            N = read();
            Pos[] posList = new Pos[N+1];
            parent = new int[N+1];
            for(int i=1;i<=N;i++) {
                parent[i] = i;
            }

            for(int i=0;i<N;i++) {
                int a = read();
                int b = read();
                int c = read();
                posList[i+1] = new Pos(a,b,c);
            }

            for(int i=1;i<=N;i++) {
                for(int j=i+1;j<=N;j++) {
                    if(findParent(i) == findParent(j)) continue;
                    double dis = calDistance(posList[i].x, posList[j].x, posList[i].y, posList[j].y);
                    if(dis <= (posList[i].w + posList[j].w)) {
                        unionParent(i,j);
                    }
                }
            }
            List<Integer> arr = new ArrayList<>();
            for(int i=1;i<=N;i++) {
                if(!arr.contains(findParent(i))) arr.add(parent[i]);
            }
            sb.append(arr.size() + "\n");
        }
        System.out.println(sb);
    }
}