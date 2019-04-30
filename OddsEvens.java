import java.util.Arrays;


public class OddsEvens {

	static int[] solve(int[] arr) {
		
		int i=0, j=arr.length-1;
		
		while (i<j) {
			if (arr[j] %2 == 0) {
				int temp = arr[j];
				arr [j] = arr[i];
				arr[i] = temp;
				i++;
			} else {
				j--;				
			}
		}
		return arr;
	}
	
	public static void main (String[] args) {
		int[] arr = {3,4,5,6,81,12,7,19};
		System.out.println(Arrays.toString(solve(arr)));
	}

}
