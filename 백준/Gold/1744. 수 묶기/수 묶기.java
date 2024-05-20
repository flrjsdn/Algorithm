import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> minus = new ArrayList<>();
		ArrayList<Integer> plus = new ArrayList<>();
		int zero = 0;
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			if(x == 0) zero++;
			else if(x > 0) plus.add(x);
			else minus.add(x);
		}
		
		Collections.sort(minus, Collections.reverseOrder());
		Collections.sort(plus);
		int result = 0;
		
		int cntM = minus.size();
		int iM = 1;
		while(cntM != 0) {
			int a = minus.size()-iM;
			int b = minus.size()-iM-1;
			if(a < 0) { //minus가 없음
				break;
			}else if(b < 0) { //minus가 하나 남음
				if(zero <= 0) {
					result += minus.get(a);
				}
				break;
			}
			
			result += (minus.get(a) * minus.get(b));
			iM += 2;
		}
		
		
		int cnt = plus.size();
		int i = 1;
		while(cnt != 0) {
			int a = plus.size()-i;
			int b = plus.size()-i-1;
			if(a < 0) {
				break;
			}else if(b < 0) {
				result += plus.get(a);
				break;
			}
			
			if(plus.get(a) == 1 || plus.get(b) == 1) {
				result += plus.get(a) + plus.get(b);
			}else {
				result += plus.get(a) * plus.get(b);
			}
			i += 2;
		}
		System.out.println(result);
	}
}