public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		String[] strArray = {"flower","flow","flight"};
		
		System.out.println("Longest Common Prefix : " + longestCommonPrefix(strArray));
	}

	private static String longestCommonPrefix(String[] strArray) {
		// uses the first string as the prefix, then iterates over each string in the array and exits at the
		// index where there is a mismatch. The prefix is then shortened via substring for the next comparison
		String prefix = strArray[0];
		
		for (int i=0; i< strArray.length; i++) {
			
			int j=0;
			while (j<prefix.length() && j<strArray[i].length() && prefix.charAt(j) == strArray[i].charAt(j)) { 
				System.out.println("Loop : "+ i + " " + strArray[i] + " Prefix char: " +  " " + prefix.charAt(j) +
						 " " + strArray[i].charAt(j));
				j++;
			}
			prefix = prefix.substring(0, j);
		}
		
		return prefix;
	}

}
