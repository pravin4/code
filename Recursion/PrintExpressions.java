package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class PrintExpressions {

	public static void main(String[] args) {
		String[] result = generate_all_expressions("22", 4);
		for (String s : result) {
			System.out.println(s);
		}	
	}
	
	static String[] generate_all_expressions(String digits, long target){ 		
		List<String> out = new ArrayList<String> ();
		for (int i = 1; i <= digits.length(); i++) {
			String current = digits.substring(0, i);
			int counter=0;
			check(0, Integer.parseInt(current), digits.substring(i), target, current, out);
		}
		out.add(0, out.size() + " different expressions possible.");
		return out.toArray(new String[0]);
	}
	
	static void check(int sum, int previous, String digits, long target, String expr, List<String> out) {
		if (digits.length() == 0) {
			if (sum + previous == target) {
				out.add(new String(expr));
			}
		} else {
			for (int i = 1; i <= digits.length(); i++) {
				int current = Integer.parseInt(digits.substring(0, i));
				String remaining = digits.substring(i);
				check(sum + previous, current, remaining, target, expr + "+" + current, out);
				check(sum, previous * current, remaining, target, expr + "*" + current, out);
				check(sum + previous, -current, remaining, target, expr + " - " + current, out);
			}
		}
	}
}