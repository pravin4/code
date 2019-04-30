package Recursion;

public class BunnyEars {
	public static void main(String[] args) {
		System.out.println(bunnyEars2(6));
	}

	public static int bunnyEars2(int bunnies) {

		if (bunnies == 0) return 0;
		if (bunnies == 1) return 2;

		if (bunnies % 2 == 0) {
			return 3 + bunnyEars2(bunnies-1);
		}
		if (bunnies % 2 == 1) {
			return 2 + bunnyEars2(bunnies-1);
		}
		return bunnies;
	}

}
