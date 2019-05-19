package Dynamic_Programming;

public class CheckArraySubset {

	public static void main(String[] args) {
		int [] arr = new int[] {5,2,3,7,3,5,5};
		int sum = 0;
		for (int j=0; j< arr.length; j++) {
			sum += arr[j];
		}
		System.out.println(testForTie(arr, arr.length, sum));
		System.out.println(testForTieDP(arr, arr.length, sum));
	}
	
	private static boolean testForTie(int[] arr, int length, int sum) {
		if (sum == 0 || sum%2 != 0) return false;
		return testForTie(arr, length, 0, sum/2);
	}

	private static boolean testForTie(int[] arr, int length, int i, int sum) {

		if (i == length) return false;
		if (sum == 0) return true;
		boolean result = false;
		
		if (sum - arr[i] >= 0 ) {
			result = testForTie(arr,length, i+1, sum-arr[i]);
		}
		return result || testForTie(arr,length, i+1, sum);
	}
	
	private static boolean testForTieDP(int[] arr, int length, int sum) {
		sum = sum/2;
		boolean DPTable[][] = new boolean[length+1][sum+1];
		for (int i=0; i<=length; i++) DPTable[i][0] = true;
		for (int j=0; j<=sum; j++) DPTable[length][j] = false;

		for (int i=length-1; i >= 0; i--) {
			for (int j=1; j<=sum; j++) {
				boolean result = false;
				
				if (j-arr[i] >= 0) {
					result = DPTable[i+1][j-arr[i]];
				}
				DPTable[i][j] = result || DPTable[i+1][j];
			}
		}		
		return DPTable[0][sum];
	}
	
}
