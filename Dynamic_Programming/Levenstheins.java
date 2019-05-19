package Dynamic_Programming;

public class Levenstheins {

	public static void main(String[] args) {
		String str1 = "bat", str2 = "boil";

		System.out.println(editDistanceDP(str1, str2));
	}

	private static int editDistanceDP(String str1, String str2) {
		int len1 = str1.length(), len2 = str2.length();

		int[][] DPTable = new int[len1 + 1][len2 + 1];
		// initialize last row and column of the DP table
		for (int i = 0; i < len1; i++)
			DPTable[i][len2] = len1 - i;
		for (int j = 0; j < len2; j++)
			DPTable[len1][j] = len2 - j;

		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {

				// if the strings are equal
				if (str1.charAt(i) == str2.charAt(j))
					DPTable[i][j] = DPTable[i + 1][j + 1];

				else {
					DPTable[i][j] = 1 + (Math.min(DPTable[i][j + 1],
							Math.min(DPTable[i + 1][j], DPTable[i + 1][j + 1])));
				}
			}
		}
		return DPTable[0][0];
	}
}
