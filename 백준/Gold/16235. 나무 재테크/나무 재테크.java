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

    static int n,m,k;
    static int[] dx = {1,-1,0,0,1,1,-1,-1};
    static int[] dy = {0,0,1,-1,1,-1,1,-1};
    static int[][] map;
    static int[][] enegy;
    static ArrayList<Integer>[][] trees;

    static void spring() {

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(trees[i][j].size() == 0) continue;
                ArrayList<Integer> graph = new ArrayList<>();
                Collections.sort(trees[i][j]);
                int index = trees[i][j].size();
                for(int l=0;l<trees[i][j].size();l++) {
                    if(trees[i][j].get(l) <= enegy[i][j]) {
                        enegy[i][j] -= trees[i][j].get(l);
                        graph.add(trees[i][j].get(l) + 1);
                    } else {
                        index = l;
                        break;
                    }
                }

                for(int l=index;l<trees[i][j].size();l++) {
                    enegy[i][j] += trees[i][j].get(l) / 2;
                }

                trees[i][j] = graph;
            }
        }
    }

    static void autumn() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                for(int tree : trees[i][j]) {
                    if(tree % 5 == 0) {
                        for(int l=0;l<8;l++) {
                            int nx = i + dx[l];
                            int ny = j + dy[l];
                            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
                            trees[nx][ny].add(1);
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                enegy[i][j] += map[i][j];
            }
        }
    }

    // static void print() {
    //     for(int i=0;i<n;i++) {
    //         for(int j=0;j<n;j++) {
    //             System.out.print(trees[i][j]);
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();

    //     for(int i=0;i<n;i++) {
    //         for(int j=0;j<n;j++) {
    //             System.out.print(enegy[i][j] + " ");
    //         }
    //         System.out.println();
    //     }
    //     System.out.println();
    // }
    
    public static void main(String[] args) throws Exception {
        n = read(); m = read(); k = read();
        map = new int[n][n];
        enegy = new int[n][n];
        trees = new ArrayList[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                trees[i][j] = new ArrayList<>();
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = read();
                enegy[i][j] += 5;
            }
        }

        for(int i=0;i<m;i++) {
            trees[read()-1][read()-1].add(read());
        }
        while(k-->0) {
            spring();
            autumn();
            winter();
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ans += trees[i][j].size();
            }
        }
        System.out.println(ans);
    }
}