import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KadaneAlgorithm {

	public static void main(String[] args) {
		//int[] input = {5,4,-1,7,8};
		int[] input = {-2,1,-3,4,-1,2,1,-5,4};

		int[] input2 = {-11,0};

		System.out.println(longestSubArray(input));
		
		System.out.println(longestSubArray(input2));

	}

	private static int longestSubArray(int[] input) {
		
		if (input == null) return 0;
		if (input.length == 1) return input[0];
		int max_so_far = 0;
		int max_here = 0;
		int start=0, end=0, s=0;
		boolean areAllNumbersNegative = true;
		int lowestNegativeNumber = Integer.MIN_VALUE;
		
		// here you keep track of the overall sum using max_so_far, also track intermediate sum using max_here
		// also whenever max_here goes negative means we have to reset the array count hence s tracks that
		// also start gets reset to s whenever we encounter a negative as we have to start checking again
		// the reason we set max_here to 0 when it goes below negative is that we need to discard that value without counting for future adds
		
		for (int i=0; i< input.length; i++) {
			if (input[i] >= 0) areAllNumbersNegative = false;
			if (input [i] < 0 && areAllNumbersNegative) {
				lowestNegativeNumber = Math.max(lowestNegativeNumber, input[i]);
			}
			max_here += input[i];
			if (max_so_far < max_here) {
				max_so_far = max_here;
				start = s;
				end = i;
			}
			if (max_here < 0) {
				max_here = 0;
				s = i+1;
			}
		}
		System.out.println("Start : " + input[start] + " End : " + input[end]);
		return areAllNumbersNegative ? lowestNegativeNumber : max_so_far;
	}

	@Test
	public void testNull() {
	
		int[] input = null;
		assertEquals(0, longestSubArray(input));
	}
	
	@Test
	public void testSingle() {
	
		int[] input = {5,4,-1,7,8};
		assertEquals(23, longestSubArray(input));
	}
	
	@Test
	public void testSingleNegative() {
	
		int[] input = {-1};
		assertEquals(-1, longestSubArray(input));
	}
	
	@Test
	public void testNegative() {
	
		int[] input = {-11,0};
		assertEquals(0, longestSubArray(input));
	}
	
	@Test
	public void testAllNegative() {
	
		int[] input = {-11,-7};
		assertEquals(-7, longestSubArray(input));
	}
	
	@Test
	public void testMain() {
	
		int[] input = {-11,-7};
		assertEquals(-7, longestSubArray(input));
	}
	
}
