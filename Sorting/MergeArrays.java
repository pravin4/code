package Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Problem of merging k sorted arrays, here the priority queue maintains a min heap
 * Once you insert into a priority queue the min element is outputted from each array 
 * which forms the result loop
 * @author prajadhav
 *
 */

public class MergeArrays {

	static class Node implements Comparable<Node> {
		int array, index, value;

		Node(int arr, int ind, int val) {
			this.array = arr;
			this.index = ind;
			this.value = val;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.value, o.value);
		}
	}

	static int[] mergeArrays(int [][] arrays) {
		PriorityQueue<Node> pq = returnMinMaxPQ(arrays);

		if (pq == null) return null;
		int size = 0;
		for (int i = 0; i < arrays.length; i++) {
			// here size of resultant array is the sum of sizes of the k arrays
			size += arrays[i].length;
			if (arrays[i].length > 0) {
				// only adds the zeroeth element of each array
				pq.add(new Node(i, 0, arrays[i][0]));
			}
		}
		
		// at any point in time there will always be k elements in the priority queue
		// each Node will have a array pointer and an index into the array that it belongs
		// here the comparator will check the value to determine which one to insert into result array
		// once inputted into the result array the next index of the Node will be pulled up and the action repeats till queue empty
		int[] result = new int[size];
		for (int i = 0; !pq.isEmpty(); i++) {
	        Node n = pq.poll();
			System.out.println(n.array + " " + n.index + " " + n.value);
	        result[i] = n.value;
	        int newIndex = n.index + 1;
	        if (newIndex < arrays[n.array].length) {
	            pq.add(new Node(n.array, newIndex, arrays[n.array][newIndex]));
	        }
	    }
		return result;
	}
	
	@SuppressWarnings("unused")
	static PriorityQueue<Node> returnMinMaxPQ(int[][] arr) {		
		for (int i=0; i< arr.length; i++) {
			if (arr[i][0] < arr[i][arr[i].length-1]) {
				return new PriorityQueue<Node>();
			} else {
				return new PriorityQueue<Node>(arr.length, Collections.reverseOrder());
			}
		}
		return null;
	}

	public static void main(String[] args) {
		
		int [][] arrays = {{1,3,4}, {2,7,10}, {5,6,8}};
		int [][] descArrays = {{21,13,4}, {22,17,10}, {25,16,8}};

		System.out.println(Arrays.toString(mergeArrays(arrays)));
		//System.out.println(Arrays.toString(mergeArrays(descArrays)));

	}

}
