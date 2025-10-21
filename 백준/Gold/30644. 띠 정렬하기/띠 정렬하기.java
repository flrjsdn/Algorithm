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

    static class Node implements Comparable<Node> {
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.num, other.num);
        }
    }
    
    public static void main(String[] args) throws IOException {
        int N = read();
        Node[] nList = new Node[N];
        for(int i=0;i<N;i++) {
            nList[i] = new Node(read(), i);
        }
        Arrays.sort(nList);

        int cnt = 0;
        for(int i=0;i<N-1;i++) {
            if(Math.abs(nList[i].index - nList[i+1].index) != 1) cnt++;
        }
        System.out.println(cnt);
    }
}