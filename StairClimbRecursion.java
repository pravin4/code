
public class StairClimbRecursion {

	public static void main(String[] args) {
		int n=5;
		int[] step = {1,2,3};
		
		System.out.println(climbStairs(n, step));
	}
	
	public static int climbStairs(int n, int[] step) {
		
		if (n==0) return 1;
		if (n<0) return 0;

		int result = 0;
		
		for (int i=0; i< step.length; i++) {
			result += climbStairs(n-step[i], step);
		}		
		return result;
		
 	}
}
