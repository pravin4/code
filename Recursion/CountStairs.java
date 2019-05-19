package Recursion;

public class CountStairs {
	
	public static void main(String[] args) {
		int numStairs = 6;
		int[] step = {2,3};
		System.out.println(countStairs(numStairs, step));
		System.out.println(countStairsDP(numStairs, step));

	}
	
	static int countStairs(int numStairs, int[] step) {
		
		//recurrence base case
		if (numStairs == 0) return 1;
		if (numStairs < 0) return 0;
		
		//recurrence relationship: f(n) = Sum from (i to k) {f(n - step[i])}
		int result=0;
		for (int i=0; i< step.length; i++) {
			result += countStairs(numStairs-step[i], step);
		}
		return result;
	}
	
	
	static int countStairsDP(int numStairs, int[] step) {
		
		int[] currentCount = new int[numStairs+1];
		
		currentCount[0] = 1;
		
		for (int i=1; i<=numStairs; i++) {
			for (int currentStep: step) {
				int previousStep = i-currentStep;
				if (previousStep >= 0) {
					currentCount[i] += currentCount[previousStep];
				}
			}
		}
		
		return currentCount[numStairs];
	}
}
