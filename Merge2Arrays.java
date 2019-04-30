import java.util.Arrays;

public class Merge2Arrays {
	static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int i=0, j=0, k = 0;
        int [] merge_array = new int[arr2.length]; 
        while (i < arr1.length && j<arr2.length) {
        	if (arr1[i] == 0) {
        		i++;
        		break;
        	}
        	if (arr2[j] == 0) {
        		j++;
        		break;
        	}
        	if (arr1[i] < arr2[j]) {
        		merge_array[k] = arr1[i];
        		i++; k++;
        	} else {
        		merge_array[k] = arr2[j];
        		j++; k++;
        	}
        }
        while (i<arr1.length) {
        	merge_array[k] = arr1[i];
            i++; k++;
        }
        while (j<arr1.length) {
        	merge_array[k] = arr2[j];
            j++; k++;
        }
		return merge_array;
    }
	
	public static void main(String[] args) {
		int [] arr1 = {2};
		int [] arr2 = {1,0};
		System.out.println("Merged Arrays: " + Arrays.toString(merger_first_into_second(arr1,arr2))) ;
	}
}
