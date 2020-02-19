package vishal.codesignal.solution;

import java.util.HashSet;
import java.util.Set;

public class Sudoku2 {

	public static void main(String[] args) {
		char c[][] = { { '.', '.', '.', '1', '4', '.', '.', '2', '.' }, 
					   { '.', '.', '6', '.', '.', '.', '.', '.', '.' },
					   { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, 
					   { '.', '.', '1', '.', '.', '.', '.', '.', '.' },
					   { '.', '6', '7', '.', '.', '.', '.', '.', '9' }, 
					   { '.', '.', '.', '.', '.', '.', '8', '1', '.' },
					   { '.', '3', '.', '.', '.', '.', '.', '.', '6' }, 
					   { '.', '.', '.', '.', '.', '7', '.', '.', '.' },
					   { '.', '.', '.', '5', '.', '.', '.', '7', '.' } };
		Sudoku2 sud = new Sudoku2();
		System.out.println(sud.sudoku2(c));
	}

	boolean sudoku2(char[][] grid) {

		Set<String> set = new HashSet<String>();

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (grid[row][col] != '.' && !set.add(grid[row][col] + " in row " + row))
					return false;
				if (grid[row][col] != '.' && !set.add(grid[row][col] + " in col " + col))
					return false;
				if (grid[row][col] != '.' && !set.add(grid[row][col] + " in square " + row / 3 + " " + col / 3))
					return false;
			}
		}

		return true;
	}
}
