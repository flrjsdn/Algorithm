class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
		for(int i=1;i<n;i*=2) {
			answer+=1;
		}
		
		a--;b--;
		
		while(true) {
			n /= 2;
			if((a/n) != (b/n)) {
				break;
			}else {
				answer -=1;
			}
		}

        return answer;
    }
}