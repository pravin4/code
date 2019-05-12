package Graphs;

public class Celebrity {

	// time complexity O(n), space complexity O(1)
	static int universalSync(int a[][], int n) {
		
		int row=0, col=0;

		while (row < n && col < n) {
			if (a[row][col] == 1) row++; // keep going as we found someone that at least one person knows 
			// here if it is not zero then increment the column since we can ignore the row
			else col++;
		}
		// goes out of bounds
		if (row == n) return -1;
		else // scan row everything should be 0 and column 1 should be n-1
			return row;		
	}
}
