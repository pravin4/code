import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;


public class TopK {
	
	static int[] topK(int[] arr, int k) {

		TreeSet<Integer> store = new TreeSet<Integer>(Collections.reverseOrder());
		for (int i : arr) {
			store.add(i);
		
			if (store.size() > k) {
				store.pollLast();
			}
		}

		int[] kArray = new int[store.size()];
		int i = 0;
		for (Integer value : store) {
			if (i >= k) break;
			kArray[i] = value;
			i++;
		}        	
		return kArray;
	}

    
	//static int[] topK(int[] arr, int k) {
        // TreeSet will maintain set of elements in a sorted fashion
		//TreeSet<Integer> tree = new TreeSet<Integer>();
        /*
        We will add all elements to the sorted set and when size of the set increases over 
        required size K, we will remove the smallest element*/
        
		/*for (int x : arr) {
			tree.add(x);
			if (tree.size() > k) {
				tree.pollFirst();
			}
		}
		int ans[] = new int[tree.size()];
		int ptr = 0;
		for (int x : tree) {
			ans[ptr++] = x;
		}
		return ans;
	}*/

	
	public static void main (String[] args) {
		int[] arr = {5,6,1,4,1,8,2,4,1,7,9,3,2,1};
		System.out.println(Arrays.toString(topK(arr,2)));
	}
}
