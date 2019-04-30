package Recursion;

public class Count8 {

	public static void main(String[] args) {
		System.out.println(count8(81890088));
	}
	
	static int count8(int n) {
		return count8(n, false);
	}
	
	static int count8(int n, boolean isEightPrevious) {
		if (n % 10 == 0 && n/10 == 0) return 0;

		if (n % 10 == 8 && !isEightPrevious) {
			System.out.println("First 8: " + n + " " + n%10);
			return 1 + count8(n/10, true);
		}
		else if (n % 10 == 8 && isEightPrevious) {
			System.out.println("Second 8: " + n + " " + n%10);
			return 2 + count8(n/10, true);
		}
		else {
			System.out.println("Not 8: " + n + " " + n%10);
			return count8(n/10, false);
		}
	}
}
