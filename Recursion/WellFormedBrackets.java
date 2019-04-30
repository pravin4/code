package Recursion;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WellFormedBrackets {

	/*	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] res;
		int n;
		n = Integer.parseInt(in.nextLine().trim());

		res = find_all_well_formed_brackets(n);
		for(int res_i = 0; res_i < res.length; res_i++) {
			bw.write(String.valueOf(res[res_i]));
			bw.newLine();
		}

		bw.close();
	}*/

	public static void main(String[] args) {
		find_all_well_formed_brackets(2);
	}

	static void find_all_well_formed_brackets(int n) {
		StringBuilder str = new StringBuilder();
		parens(n*2, n*2, str);
	}

	private static void parens(int left, int right, StringBuilder str) {
		if (left == 0 && right == 0) {
			System.out.println(str.toString());
		} 
		
		if (left > right) // means closing parentheses is more than open ones
			return;

		// if we have a left bracket left we add it
		if (left == right) {
			parens(left-1, right, str.append("("));
			//System.out.println("left "+ left + " " + str);
		}

		// if we have a right bracket left we add it
		if (right > left) {
			parens(left-1, right, str.append("(")); 
			parens(left, right-1, str.append(")")); 
			//System.out.println("right " + right + " " +str);
		}
	}
}
