import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static int[] parent;
    
    static int findParent(int num) {
        if(num == parent[num]) return num;
        return parent[num] = findParent(parent[num]);
    }

    static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i=1;i<=n;i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int trueCnt = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<trueCnt;i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer>[] arr = new ArrayList[m];

        for(int i=0;i<m;i++) {
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0;i<m;i++) {
            boolean check = true;
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> partySet = new HashSet<>();
            int party = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            arr[i].add(start);
            for(int j=1;j<party;j++) {
                int next = Integer.parseInt(st.nextToken());
                arr[i].add(next);
                if(findParent(start) != findParent(next)) unionParent(start, next);
            }
        }

        int ans = 0;
        for(int i=0;i<m;i++) {
            boolean flag = true;
            s:for(int next : arr[i]) {
                for(int man : set) {
                    if(findParent(man) == findParent(next)) {
                        flag=false;
                        break s;
                    }
                }
            }
            if(flag) ans++;
        }

        System.out.println(ans);
    }
}