package Sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MagicalTriplet {
    /*
     * Time Complexity: O(N^2+Nlog(N))
     * Space Complexity: O(N^3)
     */
    static String[] originalSolution(ArrayList<Integer> input) {
        TreeSet<String> set = new TreeSet<>();
        int n = input.size();
        // We will sort the input first. This is a pre-requisite for two pointer technique.
        Collections.sort(input);
        for (int index = 0; index < n; index++) {
            int currentElement = input.get(index);
            // We need sum -currentElement so the sum of all three elements would be zero.
            int neededSum = -currentElement;
            // Maintain a left index to the next of current index
            // Maintain a right index to the last element of the array
            int left = index + 1, right = n - 1;
            while (left < right) {
            	int sum = input.get(left) + input.get(right);
                if (sum == neededSum) {
                    /*
                     * If we find the triplet
                     * 1. Add it to the set
                     * 2. Move either the left pointer or the right pointer
                     */
                    if (!set.contains(
                    		currentElement + "," + input.get(left) + "," + input.get(right)
                    	)) {
                        set.add(currentElement + "," + input.get(left) + "," + input.get(right));
                    }
                    left++;
                } else if (sum > neededSum) {
                    // If sum is more than intended, decrement the right pointer
                    right--;
                } else {
                    // If sum is less than intended, increment the left pointer
                    left++;
                }
            }
        }
        // Return the array from the set
        return set.toArray(new String[set.size()]);
    }
    
    
    static String[] findZeroSum(int[] arr) {
        int n = arr.length; 
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Set<String> resultSet = new HashSet<String> ();
        
        int low=0, high = 0;
        
        for (int i=0; i<n-2; i++) {
        	low = i+1; high = n-1;
            
        	while(low < high) {	
	        	int sum = arr[i] + arr[low] + arr[high];
	    		System.out.println(sum + ":" + arr[i] + "," + arr[low] + "," + arr[high]);
	        	if (sum == 0) {
	        		resultSet.add(arr[i] + "," + arr[low] + "," + arr[high]);
	        		low++; 
	        		high--;
	        	} else if (sum < 0) {
	        		low++;
	        	} else {
	        		high--;
	        	}
            }
        }
    	
		return resultSet.toArray(new String[0]);
    	
    }
    
	public static void main (String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer> (Arrays.asList(2,-2, 0, 1, 3, -3));
		
		int[] arr1 = {2,-2, 0, 1, 3, -3};
		
		//System.out.println(Arrays.toString(originalSolution(arr)));
		System.out.println(Arrays.toString(findZeroSum(arr1)));

	}
}