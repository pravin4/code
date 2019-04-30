package Recursion;

public class CountStairs {
	
	public static void main(String[] args) {
		int numStairs = 3;
		int[] step = {1,2};
		System.out.println(countStairs(numStairs, step));
	}
	
	static int countStairs(int numStairs, int[] step) {
		
		//recurrence base case
		if (numStairs ==0) return 1;
		if (numStairs < 0) return 0;
		
		//recurrence relationship: f(n) = Sum from (i to k) {f(n - step[i])}
		int result=0;
		for (int i=0; i< step.length; i++) {
			result += countStairs(numStairs-step[i], step);
		}
		return result;
	}
}
