
public class IntegerPalindrome {
	
	public static void main(String[] args) {
		System.out.println(checkPalindrome(3455743));
	}
	
	public static boolean checkPalindrome(int input) {
		int original = input;
		int reverse = 0, remainder;
		
		while (input != 0 ) {
			remainder = input%10;
			reverse = reverse * 10 + remainder;
			input = input/10;
		}
		
		return (original == reverse ? true : false);		
	}

}
