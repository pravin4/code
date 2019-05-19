package Dynamic_Programming;

public class Robbery {
	
	public static void main(String[] args) {
		int[] values = new int[] {};
		
		System.out.println(printMaxValue(values));
		System.out.println(printMaxValueDP(values));

	}

	private static int printMaxValue(int[] values) {
		return printMaxValue(values.length-1, values);
	}

	private static int printMaxValue(int i, int[] values) {
		if (i<0) return 0;
		if (i == 0) return values[0];
		if (i == 1) return Math.max(values[0], values[i]);
		
		return Math.max(printMaxValue(i-2, values) + values[i], printMaxValue(i-1, values));
	}

	private static int printMaxValueDP(int[] values) {
		
		int len = values.length;
		int[] DPTable = new int[len];
		
		if (len == 0) return 0;
		if (len == 1) return values[0]; 
		DPTable[0] = values[0];
		DPTable[1] = Math.max(values[0], values[1]);

		for (int i=2; i<len; i++) {
			DPTable[i] = Math.max(values[i] + DPTable[i-2], DPTable[i-1]);
		}
		
		return DPTable[len-1];
		
	}
}
