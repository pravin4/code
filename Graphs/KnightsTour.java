package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KnightsTour {
	public static void main(String[] args) {
		//System.out.println(find_minimum_number_of_moves(2, 7, 0, 5, 0, 1));
		System.out.println(find_minimum_number_of_moves(315, 316, 222, 123, 123, 122));
	}

	static class Cell {
		int row;
		int column;
		int depth;

		Cell (int row, int column) {
			this.row = row;
			this.column = column;
		}
	}

	static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
		if (start_row == end_row && start_col == end_col) return 0;
		int[][] board = new int[rows][cols];

		Queue<Cell> queue = new LinkedList<Cell>();
		queue.add(new Cell(start_row, start_col));

		while(!queue.isEmpty()) {
			Cell currentCell = queue.poll();

			if (currentCell.row == end_row && currentCell.column == end_col) {
				return board[currentCell.row][currentCell.column];
			}

			List<Cell> nextCells = getNeighbours(board, currentCell);
			if (nextCells != null) {
				for (Cell nextCell: nextCells) {
					// here the 2D board keeps track of every knight move and adds the depth every time one move is done
					if (board[nextCell.row][nextCell.column] == 0) {
						board[nextCell.row][nextCell.column] = board[currentCell.row][currentCell.column] + 1;
						queue.add(nextCell);
					}
				}					
			}
		}  		   	
		return -1;
	}

	public static List<Cell> getNeighbours(int[][] board, Cell currCell) {
		List<Cell> pos = new ArrayList<Cell>();
		// defines the positions that a knight can take from a certain position on a board
		pos.add(new Cell(2,1));
		pos.add(new Cell(1,2));
		pos.add(new Cell(-2,1));
		pos.add(new Cell(-2,-1));
		pos.add(new Cell(-1,2));
		pos.add(new Cell(-1,-2));
		pos.add(new Cell(1,-2));
		pos.add(new Cell(2,-1));

		List<Cell> result = new ArrayList<Cell>();
		// from the current row and position gives all the cells that the knight can jump to
		int row = currCell.row, col = currCell.column;
		for (Cell cur: pos){
			if (row + cur.row >= 0 && col + cur.column >= 0 // lower bound && upper bound of the board
					&& (row + cur.row) < board.length && (col + cur.column) < board[row].length) {

				result.add(new Cell(cur.row + row, cur.column + col));
			}
		}
		return result;
	}
}
