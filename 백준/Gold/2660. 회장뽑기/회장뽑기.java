import java.util.*;

class Node implements Comparable<Node>{
	private int index;
	private int score;
	
	public Node(int index, int score) {
		this.index = index;
		this.score = score;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getScore() {
		return this.score;
	}
	
	@Override
	public int compareTo(Node other) {
		return Integer.compare(this.score, other.score);
	}
}

public class Main {
	public static final int INF = (int) 1e9;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		
		for(int i=0;i<=n;i++) {
			Arrays.fill(arr[i], INF);
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==j) arr[i][j] = 0;
			}
		}
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == -1 && b == -1) break;
			arr[a][b] = arr[b][a] = 1;
		}
		
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
				}
			}
		}
		ArrayList<Node> graph = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			int max = 0;
			for(int j=1;j<=n;j++) {
				if(arr[i][j] > max) max = arr[i][j];
			}
			graph.add(new Node(i, max));
		}
		Collections.sort(graph);
		int cnt = 1;
		for(int i=1;i<graph.size();i++) {
			if(graph.get(i).getScore() == graph.get(0).getScore()) {
				cnt++;
			}
		}
		System.out.println(graph.get(0).getScore() + " " + cnt);
		for(int i=0;i<graph.size();i++) {
			if(graph.get(i).getScore() == graph.get(0).getScore()) {
				System.out.print(graph.get(i).getIndex()+" ");
			}
		}
	}
}