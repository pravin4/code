package Dynamic_Programming;

public class MaxPriceRope {
	
	public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
		System.out.println(maxPrice(arr, size));
		System.out.println(maxPriceDP(arr, size));
	}

	private static int maxPrice(int[] prices, int length) {
				
		if (length <= 0) return 0;
		int finalPrice = 0;
		
		for (int i=0; i<length; i++) {
			finalPrice = Math.max(finalPrice, prices[i] + maxPrice(prices, length-i-1));
		}
		
		return finalPrice;
	}
	

	private static int maxPriceDP(int[] prices, int length) {
		int[] DPTable = new int[length+1];
		DPTable[0] = 0;
		
		for (int i=1; i<= length; i++) {
			int finalPrice = 0;
			for (int j=0; j<i; j++) 
				finalPrice = Math.max(finalPrice, prices[j] + DPTable[i-j-1]);
			DPTable[length] = finalPrice;
		}
		return DPTable[length];
	}
	
}
