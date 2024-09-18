import java.io.*;
import java.util.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int read() throws Exception {
		if(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return Integer.parseInt(st.nextToken());
	}

	static class Node{
		int data;
		int left;
		int right;
		
		Node(int data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	static Node[] list;
	static int ans, lastNode, nodeCnt;
	static boolean[] visited;
	static int n;
	static boolean flag;
	
	static void inorder(int node) {
		if(list[node].left != -1) {
			inorder(list[node].left);
		}
		
		lastNode = node;
		
		if(list[node].right != -1) {
			inorder(list[node].right);
		}
	}
	
	static void dfs(int node) {
		visited[node] = true;
		
		if(list[node].left != -1 && !visited[list[node].left]) {
			dfs(list[node].left);
			ans++;
		}
		
		if(list[node].right != -1 && !visited[list[node].right]) {
			dfs(list[node].right);
			ans++;
		}
		
		if(node == lastNode) {
			flag = true;
			return;
		}
		if(flag) return;
		ans++;
	}
	public static void main(String[] args) throws Exception {
		n = read();
		list = new Node[n+1];
		visited = new boolean[n+1];
		
		for(int i=0;i<n;i++) {
			int parent = read();
			int left = read();
			int right = read();
			list[parent] = new Node(parent, left, right);
		}
		ans = 0;
		inorder(1);
		
		nodeCnt = 0;
		dfs(1);
		System.out.println(ans);
    }
}
