import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParathensisMatcher {
	
	public static void main(String[] args) {
		System.out.println(matcher("[(())]()"));
	}
	
	public static boolean matcher(String s) {
		
		int i=0;
		int length = s.length();
		Stack<Character> st = new Stack<Character>();

		Map<Character, Character> bracketPattern = new HashMap<Character, Character> ();
		bracketPattern.put(')', '(');
		bracketPattern.put(']', '[');
		bracketPattern.put('}', '{');
		
		if (length == 0 || length %2 !=0) return false;
		
		while (i< length) {			
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				st.push(s.charAt(i));
			} else if (st.isEmpty() || st.pop() != bracketPattern.get(s.charAt(i))) {
				return false;
			}
			i++;
		}		
		return st.isEmpty();
	}

}
