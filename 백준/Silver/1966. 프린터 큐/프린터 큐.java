import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	public int index;
	public int weight;
	
	public Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.weight, other.weight);
	}
}

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			Queue<Node> q = new LinkedList<>();
			Integer[] wList = new Integer[n];
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int weight = Integer.parseInt(st.nextToken());
				q.add(new Node(i, weight));
				wList[i] = weight;
			}
			
			Arrays.sort(wList, Collections.reverseOrder());
			s: for(int i=0;i<n;i++) { //크기 차례대로
				while(true) {
					Node now = q.poll(); //현재 Queue
					if(wList[i] != now.weight) {//지금 나가야되는 수와 다르면
						q.add(now); //다시 Queue로
					}else { //지금 나가야되는 수와 같으면
						if(m == now.index) { //만약 index도 같으면
							System.out.println(i+1); //현재 순서 출력
							break s;
						}
						break; //다음 순서로
					}
				}
			}
			
		}
	}
}