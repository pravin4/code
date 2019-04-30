package Recursion;

public class CountPathsSolve {
	
	public static void main(String[] args) {
		int [][] arr = new int[3][3];
		System.out.println(countPaths( arr, 0, 0));
	}

	private static int countPaths(int[][] arr, int i, int j) {
		
		int rows = arr.length;
		int cols = arr[0].length;
		
		if (i >= rows || j >= cols) return 0;
		
		if (i == rows-1 ||  j == cols-1) return 1;
		
		return (countPaths(arr, i+1, j) + countPaths(arr, i, j+1));
	}

}
