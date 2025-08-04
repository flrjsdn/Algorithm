import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int read() throws Exception {
        if(st==null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static int target, n, m, ans;
    static int[] aList, bList;
    static ArrayList<Integer> aArr, bArr;
    
    public static void main(String[] args) throws Exception {
        target = read();
        m = read(); n = read();
        aList = new int[m*2+1];
        bList = new int[n*2+1];
        aArr = new ArrayList<>();
        bArr = new ArrayList<>();

        for(int i=1;i<=m;i++) {
            aList[i] = read();
            aList[i+m] = aList[i];
            aArr.add(aList[i]);
        }
        for(int i=1;i<=2*m;i++) {
            aList[i] += aList[i-1];
        }
        
        for(int i=1;i<=n;i++) {
            bList[i] = read();
            bList[i+n] = bList[i];
            bArr.add(bList[i]);
        }
        for(int i=1;i<=2*n;i++) {
            bList[i] += bList[i-1];
        }
        aArr.add(aList[m] - aList[0]);
        bArr.add(bList[n] - bList[0]);

        for(int i=2;i<m;i++) {
            for(int j=0;j<m;j++) {
                int num = aList[j+i] - aList[j];
                aArr.add(num);
            }
        }
        for(int i=2;i<n;i++) {
            for(int j=0;j<n;j++) {
                int num = bList[j+i] - bList[j];
                bArr.add(num);
            }
        }

        aArr.add(0);
        bArr.add(0);
        Collections.sort(aArr);
        Collections.sort(bArr);
        int aIndex = 0;
        int bIndex = bArr.size()-1;
        ans = 0;
        while(aIndex < aArr.size() && bIndex >= 0) {
            int a = aArr.get(aIndex);
            int b = bArr.get(bIndex);
            if(a+b == target) {
                int aCnt = 0;
                int bCnt = 0;
                while(aIndex < aArr.size() && aArr.get(aIndex) == a) {
                    aCnt++;
                    aIndex++;
                }
                while(bIndex >= 0 && bArr.get(bIndex) == b) {
                    bCnt++;
                    bIndex--;
                }
                ans += aCnt * bCnt;
            }

            if(a+b < target) aIndex++;
            if(a+b > target) bIndex--;
        }
        System.out.println(ans);
    }
}