package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * prints all brackets possible given number of brackets to use
 * System.out.println("Left :" + left + " Right : " + right + " StrSoFar: " + str);
 * @author prajadhav
 *
 */
public class WellFormedBrackets {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(find_all_well_formed_brackets(3)));
	}

	static String[] find_all_well_formed_brackets(int n) {
		List<String> out = new ArrayList<String> ();
		parens(n, n, "", out);		
		return out.toArray(new String[0]);
	}

	private static void parens(int left, int right, String str, List<String> out) {
		// base condition is all right parenthesis have been printed out
		if (right == 0) {
			out.add(str);
			return;
		} 		
		if (left > 0) {
			// if there are more left parenthesis, print that (choice 1)
			parens(left-1, right, str+("("), out);
			// else given a left print the right parenthesis if more left have been used (choice 2)
			if (left < right) {
				parens(left, right-1, str+(")"), out); 
			}
		} else {
			// print all remaining right parentheses
			parens(left, right-1, str+(")"), out); 
		}
	}
}
