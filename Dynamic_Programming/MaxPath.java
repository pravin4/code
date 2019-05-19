package Dynamic_Programming;

public class MaxPath {
	
	public static void main(String[] args) {

	    int[][] foo = new int[][] {
	        new int[] { 10, 20, 33, 0 },
	        new int[] { 11, 2, 23, 14},
	        new int[] { 21, 12, 3, 8},
	    };
	    
	    System.out.println(maxPathRecur(foo, 0, 0));
	    System.out.println(maxPathDP(foo, 0, 0));

	}
	
	static int maxPathRecur(int[][] arr, int row, int column) {
				
		if (row == arr.length || column == arr[0].length) return 0;
		
		if (row == (arr.length-1) && column == (arr[0].length-1)) return arr[row][column];
		// value at the index plus the max of the values one row down and one column across
		return arr[row][column] + Math.max(maxPathRecur(arr, row+1, column), maxPathRecur(arr, row, column+1));
		
	}
	
	static int maxPathDP(int[][] arr, int row, int column) {
		
		int rowSize = arr.length;
		int colSize = arr[0].length;

		int dpTable[][] = new int[arr.length+1][arr[0].length+1];
		// initialize the array to 0, probably not needed for primitives in java
		for (int i=0; i<colSize; i++) dpTable[i][colSize] = 0;	
		for (int i=0; i<rowSize; i++) dpTable[rowSize][i] = 0;
		
		for (int i=rowSize-1; i>=0; i--) {
			for (int j=colSize-1; j>=0; j--) {
				// this computes each value in the table from the destination n,m down to 0,0
				dpTable[i][j] = arr[i][j] + Math.max(dpTable[i][j+1],dpTable[i+1][j]);
			}
		}	
		recoverMaxPath(dpTable, arr);
		System.out.println();
		return dpTable[0][0];
	}
	
	static void recoverMaxPath(int[][] dpTable, int[][] array) {
		int rowSize = array.length;
		int colSize = array[0].length;
		
		int i=0,j=0;
		System.out.print(array[i][j] + " ");

		while (i < rowSize-1 || j < colSize-1) {
			if (dpTable[i][j+1] > dpTable[i+1][j]) {
				System.out.print(array[i][j+1] + " ");
				j+=1;
			} else {
				System.out.print(array[i+1][j] + " ");
				i+=1;
			}
		}		
	}
}
