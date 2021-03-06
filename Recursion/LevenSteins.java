package Recursion;
/**
 * prints the distance between 2 strings, 3 options insert, delete and replace
 * finds the minimum effort required to replace s1 with s2
 * @author prajadhav
 *
 */
public class LevenSteins {
	
	public static void main(String[] args) {
		String s1 = "ball";
		String s2 = "help";
		
		System.out.println(editDistance(s1, s2));
	}
	
	static int editDistance(String s1, String s2) {
		return editDistance(s1, s2, 0, 0);
	}

	
	static int editDistance(String s1, String s2, int i, int j) {
		
		if (i == s1.length() || j == s2.length()) {
			return Math.max(s1.length()-i, s2.length()-j);
		}
		
		// if the indexes are equal move the pointer to the next position on both s1 and s2
		if (s1.charAt(i) == s2.charAt(j)) {
			return editDistance(s1, s2, i+1, j+1);
		}
		
		// else use the function we derived in the mathematical tree
		return 1 + Math.min(Math.min(editDistance(s1, s2, i, j+1), 
				editDistance(s1, s2, i+1, j)), 
				editDistance(s1, s2, i+1, j+1));
		
	}

}
