package Sorting;

import java.util.Arrays;

public class MergeArraysConstant {
	
	public static void main(String[] args) {
		int [] arr1 = {1,3,5};
		int [] arr2 = {2,4,6,0,0,0};
		System.out.println("Merged Arrays: " + Arrays.toString(merger_first_into_second(arr1,arr2))) ;
	}
	
	static int[] merger_first_into_second(int[] arr1, int[] arr2) {
		
		int i=arr1.length-1, j=arr1.length-1, k=arr2.length-1;
		
		while (i>=0 && j>=0) {
			if (arr1[i] > arr2[j]) {
				arr2[k] = arr1[i];
				i--;
			} else {
				arr2[k] = arr2[j];
				j--;
			}
			k--;
		}
		while (i>=0) {
			arr2[k] = arr1[i];
			i--;
		}
		return arr2;
	}

}
