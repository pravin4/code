import java.util.Arrays;

public class DuplicateIntegerRemoval {
	
	public static void main(String[] args) {
		int[] input = {0,0,1,1,1,2,2,3,3,4};
		
		System.out.println(Arrays.toString(removeDuplicates(input)));
	}
	
	private static int[] removeDuplicates(int[] nums) {
		
		int i=1;
		
		for (int j=1; j<nums.length; j++) {
			if (nums[j] != nums[j-1]){
				nums[i] = nums[j];
				i++;
			}
		}
		
		return Arrays.copyOfRange(nums, 0, i);
	}
}
