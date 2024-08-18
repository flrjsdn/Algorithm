import java.io.*;
import java.util.*;

class Box {
	int start;
	int end;
	int unit;
	
	public Box(int start, int end, int unit) {
		this.start = start;
		this.end = end;
		this.unit = unit;
	}
}


public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		ArrayList<Box> box = new ArrayList<>();
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			box.add(new Box(a,b,c));
		}
		
		int lo = 1;
		int hi = n;
		while(lo <= hi) {
			int mid = (lo+hi) / 2;
			long cnt = 0;
			for(int i=0;i<box.size();i++) {
				if(box.get(i).end <= mid) {
					cnt += (box.get(i).end - box.get(i).start)/ box.get(i).unit + 1; 
				}else if(box.get(i).start > mid) continue;
				else {
					cnt += (mid - box.get(i).start)== 0 ? 1 : (mid-box.get(i).start)/box.get(i).unit + 1; 
				}
			}
			if(cnt >= d) hi = mid-1;
			else lo = mid + 1;
		}
		System.out.println(lo);
    }
}