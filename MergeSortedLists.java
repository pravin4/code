import java.util.Arrays;

public class MergeSortedLists {
	
	public static void main(String[] args) {
		int[] l1 = {1,3,4,7,10};
		int[] l2 = {3,5,6,8,9};
		
		int[] result = merge(l1, l2);
		System.out.println(Arrays.toString(result));
}
	
	public static int[] merge(int[] l1, int[] l2) {
		
		int i=0 ,j=0, k=0;
		int[] mergeList = new int[l1.length + l2.length];
		
		while (i<l1.length && j<l2.length)  {
			if (l1[i] < l2[j]) {
				mergeList[k]= l1[i];
				i++;
			} else if (l2[j] < l1[i]) {
				mergeList[k]= l2[j];
				j++;
			} else if (l2[j] == l1[i]) {
				mergeList[k]= l1[i];
				k++;
				mergeList[k]= l2[j];
				i++; j++;
			}
			k++;
		}
		
		while (i<l1.length) {
			mergeList[k]= l1[i];
			k++;i++;
		}
		
		while (j<l2.length) {
			mergeList[k]= l2[j];
			k++;j++;
		}
		
		return mergeList;
		
	}

}
