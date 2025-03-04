import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static int[] parent;
    static int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
    static void unionParent(int a,int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for(int i=1;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(parent[a] != parent[b]) {
                unionParent(a,b);
            }
        }

        int a = 1, b = 0;
        for(int i=2;i<=n;i++) {
            if(findParent(a) != findParent(i)) {
                b = i;
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}