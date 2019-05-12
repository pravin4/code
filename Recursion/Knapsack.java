package Recursion;

public class Knapsack {
	
	public static void main(String[] args) {
		//System.out.println(maxCapacity(0, c, w, v));
	}
	
	static int maxCapacity(int i, int k, int[] w, int[] v) {
		
		if (k<0) return Integer.MIN_VALUE;
		if (i == w.length) return 0;
		
		int includeItem = maxCapacity(i+1, k-w[i], w, v);
		
		int excludeItem = maxCapacity(i+1, k, w, v);

		int maxValue = (Math.max(includeItem, excludeItem) + v[i]) ;
		
		return maxValue;
	}

}
