package Recursion;

public class CountX {

	public static void main(String[] args) {
		System.out.println(countX("xxawxfrgx"));
		System.out.println(countHi("hiahjhikj"));
		System.out.println(changeXY("yyxxhdax"));
		System.out.println(changePi("pixypi"));
	}

	static int countX(String str) {
		return countChars(str, 0);
	}

	static int countChars(String str, int i) {
		int size = str.length();
		if (i == size) return 0;

		if (str.charAt(i) == 'x') { 
			return (1 + countChars(str, i+1));
		}
		else {
			return (countChars(str, i+1));
		}
	}

	static int countHi(String str) {
		return countChars(str, 0, false);
	}

	static int countChars(String str, int i, boolean test) {
		int size = str.length();
		if (i == size) return 0;

		if (str.charAt(i) == 'h') { 
			return (countChars(str, i+1, true));
		}
		else if (str.charAt(i) == 'i' && test) { 
			return 1 + (countChars(str, i+1, false));
		}
		else {
			return (countChars(str, i+1, false));
		}
	}
	
	static String changeXY(String str) {
		return changeXY(str, 0);
	}

	static String changeXY(String str, int i) {
		StringBuilder newString = new StringBuilder(str);
		int size = str.length();
		if (i == size) return newString.toString();

		if (str.charAt(i) == 'x') { 
			 newString.setCharAt(i, 'y');
			 return changeXY(newString.toString(), i+1);
		}
		else {
			return changeXY(newString.toString(), i+1);
		}
	}
	
	public static String changePi(String str) {
		return changePi(str, 0, false);
	}

	static String changePi(String str, int i, boolean isPrecedingP) {
		StringBuilder newString = new StringBuilder(str);
		int size = str.length();
		if (i == size) return newString.toString();

		if (str.charAt(i) == 'p') { 
			return changePi(newString.toString(), i+1, true);
		}
		
		if (str.charAt(i) == 'i' && isPrecedingP) { 
			//newString.setCharAt(i-1, Character.toChars((int) 3.14));
			return changePi(newString.toString(), i+1, false);
		}
		else {
			return changePi(newString.toString(), i+1, false);
		}
	}
}
