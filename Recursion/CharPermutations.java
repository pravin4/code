package Recursion;

import java.util.Arrays;

public class CharPermutations {

	public static void main(String[] args) {
		char[] arr = {'t','c','d','o'};
		permute(arr, 0);
		int[] numArr = {1, 3, 4, 8};
		permuteOddEven(numArr, 0);
	}

	@SuppressWarnings("unused")
	private static void permute(char[] arr, int i) {
		int size = arr.length;
		if (i == size-1) {
			System.out.println(Arrays.toString(arr)); 
			return;
		}
		for (int j=i; j<size; j++) {
			swap (arr, j, i);
			permute(arr, i+1);
			swap (arr, j, i);
		}	
	}

	private static void swap(char[] arr, int i1, int i2) {
		char temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

	private static void permuteOddEven(int[] numArr, int i) {
		int size = numArr.length;
		if (i == size-1) {
			System.out.println(Arrays.toString(numArr));
		}
		for (int j=i; j<size; j++) {
			swapNum (numArr, j, i);
			permuteOddEven(numArr, i+1);
			swapNum (numArr, j, i);
		}	
	}

	@SuppressWarnings("unused")
	private static boolean isOkToCompute(int[] numArr, int i, int j) {
		if ((numArr[i] %2 == 0 && numArr[j] %2 == 1) ||
				((numArr[i] %2 == 1 && numArr[j]  %2 == 0))) {
			return true;
		}
		return false;
	}

	private static void swapNum(int[] arr, int i1, int i2) {
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}

}
