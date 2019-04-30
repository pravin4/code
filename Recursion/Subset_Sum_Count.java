package Recursion;

public class Subset_Sum_Count {
	
	// here we are pruning the tree once the subset sum reaches 0 , we subtract from the passed in sum every time
	// when you draw the tree the sum is passed in, and you subtract the value every time
	// there is always an include and an exclude path
	// recurrence relationship : f(sum,i) = f(sum-input[i], i+1) + f(sum, i+1)
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int sum = 3;
		
		long[] arr2 = {-2,-3,1};
		long k = 4; 
		System.out.println(getSubsets(arr,sum));
		System.out.println(check_if_sum_possible(arr2,k));

	}

	static int getSubsets(int[] arr, int sum) {
		return getSubsets(arr, sum, 0);		
	}
	
	static int getSubsets(int[] arr, int sum, int i) {
		if (sum == 0) return 1;
		if (sum<0 || i==arr.length) return 0;
		
		return getSubsets(arr, sum - arr[i], i+1) + getSubsets(arr, sum, i+1);
	}
	
	
	private static boolean check_if_sum_possible(long[] arr2, long k) {
		return getSubsetsTestIter(arr2, k, 0, 0);
	}

	private static boolean getSubsetsTestIter(long[] arr2, long k, int i, int count) {
		// here we use count in the case that the input is 0, we need to check at least one element to return true
		if (k == 0 && i==arr2.length && count > 0) {
			System.out.println("i " + i + " " + arr2);
			return true;
		}
		if (i==arr2.length) return false;
		
		return getSubsetsTestIter(arr2, k - arr2[i], i+1, count+1) || getSubsetsTestIter(arr2, k, i+1, count);
	}
}
