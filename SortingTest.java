import java.util.Arrays;

public class SortingTest {
	
	static void insertionSort(int arr[]) {
		// have one pointer iterate over the main array
		// have the 2nd pointer keep track of the insertion of the new element
		// insert the new element into the array at the right position as long as it is in the less than the previous value in the index
		for (int i=0; i< arr.length; i++) {
			int j=i;
			while (j>0 && arr[j] < arr[j-1]) {
				// keep swapping till you reach the right position in the array
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j=j-1;
			}
		}
		System.out.print("Insertion Sorted Array: "+ Arrays.toString(arr) + "\n");
	}
	
	static int Partition(int[] arr, int low, int high) {	
		int pivot = arr[high];
		System.out.println(pivot + "\t");  
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than or equal to pivot 
			if (arr[j] <= pivot) 
			{ 
				i++; 
				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
		System.out.print("Partitioned Array: "+ Arrays.toString(arr) + "\n");
		return i+1; 
	}

	static void quickSort(int[] arr, int low, int high) {
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is now at right place */
			int pi = Partition(arr, low, high); 

			// Recursively sort elements before partition and after partition 
			quickSort(arr, low, pi-1); 
			quickSort(arr, pi+1, high); 
		} 
		System.out.print("Quick Sort Array: "+ Arrays.toString(arr) + "\n");
	}
	
	static void merge(int[] arr, int start, int mid, int end) {		
		int leftArrayLength = mid - start + 1;
		int rightArrayLength = end - mid;
		
        /* Create temp arrays */
        int L[] = new int [leftArrayLength]; 
        int R[] = new int [rightArrayLength]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<leftArrayLength; i++) 
            L[i] = arr[start + i]; 
        for (int j=0; j<rightArrayLength; j++) 
            R[j] = arr[mid+1+j]; 
        System.out.print("Merging Array: L"+ Arrays.toString(L) + "\t" + "Merging Array: R"+ Arrays.toString(R) + "\n");
    	
        int i=0, j=0, k=start;
		while (i < leftArrayLength && j < rightArrayLength) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++; k++;
			} else {
				arr[k] = R[j];
				j++; k++;
			}
		}
		while (i<leftArrayLength) {
			arr[k] = L[i];
			i++; k++;
		}
		
		while (j<rightArrayLength) {
			arr[k] = R[j];
			j++; k++;
		}
		System.out.print("Merge Sorted Array: "+ Arrays.toString(arr) + "\n");
	}
	
	static void mergeSort(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = low + (high-low) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid+1, high);
		merge(arr, low, mid, high);
	}
	
	static void selectionSort (int[] arr) {
		for (int i = 0; i< arr.length -1; i++) {
			int least = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[least] > arr[j] ) {
					least = j;
				}
			}
			int temp = arr[least];
			arr[least] = arr[i];
			arr[i] = temp;
		}
		System.out.print("Selection Sorted Array: "+ Arrays.toString(arr) + "\n");
	}

	public static void main(String[] args) {
			
		int[] my_array = {25, 14, 56, 15, 36, 57, 77, 18, 29, 49};
		//insertionSort(my_array);
		//quickSort(my_array, 0, my_array.length-1);
		mergeSort(my_array, 0, my_array.length-1);
		//selectionSort(my_array);

	}
}