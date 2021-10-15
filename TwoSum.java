import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,6};
		int target = 9;
		int[] result = twoSumBrute(nums, target);
		
		if (result.length == 2) {
			System.out.println(nums[result[0]] + " + " + nums[result[1]] + " = " + target);
		} else {
			System.out.println("No integers found");
		}
		
	}
	public static int[] twoSumOpt(int[] nums, int target) {
	        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
	        
	        for (int i=0; i< nums.length; i++) {
	        	tempMap.put(nums[i], i);
	        }
	        
	        for (int i=0; i< nums.length; i++) {
	        	int first = nums[i];
	        	int second = target - first;
	        	
	        	if (tempMap.containsKey(second)) {
	        		if (i == tempMap.get(second)) continue;
	        		return new int[] {i, tempMap.get(second)};
	        	}	        	
	        }
		return new int[] {};
	}
	
	public static int[] twoSumBrute(int[] nums, int target) {
		
        for (int i=0; i< nums.length; i++) {
	        for (int j=1; j< nums.length; j++) {
	        	if (nums[i] + nums[j] == target) {
	        		return new int[] { i,j};
	        	}
	        }	
        }
		return new int[] {};
	}	
}
