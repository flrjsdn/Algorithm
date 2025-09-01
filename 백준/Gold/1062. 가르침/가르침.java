import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,K,ans;
    static String[] str;
    static boolean[] visited;

    static void dfs(int index, int cnt) {
        if(cnt == K-5) {
            int count = 0;
            for(int i=0;i<str.length;i++) {
                boolean check = true;
                for(int j=0;j<str[i].length();j++) {
                    if(!visited[str[i].charAt(j)-'a']) {
                        check = false;
                        break;
                    }
                }

                if(check) count++;
            }

            ans = Math.max(ans, count);
            return;
        }

        for(int i=index;i<26;i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, cnt+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        str = new String[N];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            s.replace("anta", "");
            s.replace("tica", "");
            str[i] = s;
        }

        visited = new boolean[26];
        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;

        if(K < 5) {
            System.out.println(0);
            return;
        }
        else if(K==26) {
            System.out.println(N);
            return;
        }

        ans = 0;
        dfs(0,0);
        System.out.println(ans);
    }
}