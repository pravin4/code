package Recursion;

/** 
 * count the number of paths you can formulate on a n*m matrix
 * here the number of rows and values are represented by a 2D array
 * @author prajadhav
 *
 */
public class CountPathsSolve {
	
	public static void main(String[] args) {
		int [][] arr = new int[2][3];
		System.out.println(countPaths( arr, 0, 0));
	}

	private static int countPaths(int[][] arr, int i, int j) {

		int rows = arr.length;
		int cols = arr[0].length;
		
		// this tells you that you cannot go beyond the dimensions of the matrix, this is the guard
		if (i >= rows || j >= cols) return 0;
		
		// this means you have reached the boundary, this is the base case
		if (i == rows-1 && j == cols-1) return 1;
		
		// else recurse over the next valid state, go first one row down and then one column down till the base cases are achieved
		return (countPaths(arr, i+1, j) + countPaths(arr, i, j+1));
	}

}
