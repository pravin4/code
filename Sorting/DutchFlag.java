package Sorting;
import java.util.Arrays;


public class DutchFlag {


	public static void main(String[] args) {
		char [] arr = {'B','G','R'};
		System.out.println("Merged Arrays: " + Arrays.toString(dutch_flag_sort(arr))) ;
	}

	private static char[] dutch_flag_sort(char[] arr) {		
		int low=0, mid=0, high=arr.length-1;		
		while (mid<=high) {
			if (arr[mid] == 'B') { //high loop
				swap(arr, mid, high);
				high--; 
				// here we don't increment mid since the swapped element needs to be checked if it is the right position
			}
			else if (arr[mid] == 'R') {// low loop
				swap(arr, mid, low); 
				mid++;
				low++;
			}
			else if (arr[mid] == 'G') { // mid loop
				mid++;
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
