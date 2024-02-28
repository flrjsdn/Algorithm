import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    private int stage;
    private double fail;
    
    public Node(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }
    
    public int getStage() {
        return this.stage;
    }
    
    @Override
    public int compareTo(Node other) {
        if(this.fail == other.fail) {
            return Integer.compare(this.stage, other.stage);
        }
        return Double.compare(other.fail, this.fail);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int length = stages.length;
        ArrayList<Node> arr = new ArrayList<>();
        for(int i=1;i<=N;i++) {
            int cnt = 0;
            for(int j=0;j<stages.length;j++) {
                if(stages[j] == i){
                    cnt += 1;
                }
            }
            
            double fail = 0;
            if(length >= 1) {
                fail = (double) cnt / length;
            }
            
            arr.add(new Node(i,fail));
            length -= cnt;
        }
        
        Collections.sort(arr);
        
        for(int i=0;i<N;i++) {
            answer[i] = arr.get(i).getStage();
        }
        
        return answer;
    }
}