package Dynamic_Programming;

public class CoinCount {

	public static void main(String[] args) {
		int [] arr = {2,3,5};

		//System.out.println(coinCountRecur(38, arr));
		System.out.println(coinCountDP(12, arr));

	}

	static int coinCountRecur(int amount, int[] arr) {

		if (amount == 0) return 0;
		if (amount < 0) return 1000;

		int minCoins = 1000;

		for (int i=0; i<arr.length; i++) {
			minCoins = Math.min(coinCountRecur(amount-arr[i], arr), minCoins);
		}		
		return minCoins+1;
	}
	
	static int coinCountDP(int amount, int[] arr) {
		int[] resultArr = new int[amount+1];
		for (int i=0; i < amount+1; i++) {
			resultArr[i] = 1000;
		}
		resultArr[0] = 0;
		
		for (int a=1; a<= amount; a++) {
			for (int i=0; i< resultArr.length; i++) {
				if (i >= a) {
					resultArr[a] = Math.min(resultArr[a], resultArr[a-i]);
				}
			}
		}
		
		if (resultArr[0] != 1000) {
			resultArr[0] +=1;
		}
		
		return resultArr[0];
	}
}
