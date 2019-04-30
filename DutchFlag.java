import java.util.Arrays;


public class DutchFlag {


	public static void main(String[] args) {
		char [] arr = {'1','R'};
		System.out.println("Merged Arrays: " + Arrays.toString(dutch_flag_sort(arr))) ;
	}

	private static char[] dutch_flag_sort(char[] arr) {		
		int low=0, mid=0, high=arr.length-1;		
		while (mid<=high) {
			if (arr[mid] == 'B') { swap(arr, mid, high--); }
			else if (arr[mid] == 'R') { swap(arr, mid, low++); }
			else if (arr[mid] == 'G') { mid++;}
			else if (arr[mid] != 'R' || arr[mid] != 'G' || arr[mid] != 'B') {
				int[] anotherArray = new int[arr.length - 1]; 
				System.arraycopy(arr, 0, anotherArray, 0, mid); 
				System.arraycopy(arr, mid + 1, anotherArray, mid, arr.length - mid - 1);
			}
		}
		return arr;
	}

	private static void swap(char[] arr, int i1, int i2) {
		char temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
}
