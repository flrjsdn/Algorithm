import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
	public int start;
	public int end;
	
	public Node(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public int compareTo(Node other) {
		if(this.end == other.end) { 
			return Integer.compare(this.start, other.start);
		}
		return Integer.compare(this.end, other.end);
	}
}

class Main {
	public static int result = 1;
	public static int n;
	public static ArrayList<Node> arr;
	
	public static void check(int before) {
		for(int i=1;i<arr.size();i++) {
			if(before > arr.get(i).start) {
				continue;
			}else {
				before = arr.get(i).end;
				result++;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr.add(new Node(s,e));
		}
		Collections.sort(arr);
		
		check(arr.get(0).end);
		System.out.println(result);
	}
}