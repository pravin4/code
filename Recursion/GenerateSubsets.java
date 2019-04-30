package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSubsets {
	public static void main(String[] args) {

		String[] result = generate_all_subsets("abhdgt");
		for (String s : result) {
			System.out.println(s);
		}
	}
	static String[] generate_all_subsets(String s) {
		List<String> out = new ArrayList<String> ();

		char[] subset = new char[s.length()];
		generateSubsets(s.toCharArray(), 0, subset, 0, out);

		return out.toArray(new String[0]);
	}

	private static void generateSubsets(char[] arr, int i, char[] s, int j, List<String> out) {
		int n = arr.length; 

		if (i == n) {
			out.add(new String(s, 0, j));
			return;
		}		
		generateSubsets(arr, i+1, s, j, out);
		s[j] = arr[i];
		generateSubsets(arr, i+1, s, j+1, out);
	}
}
