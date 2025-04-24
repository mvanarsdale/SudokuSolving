package sudokuSolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** 
* 
* Class that produces sudoku board solutions
* April 21, 2025
*/


public class SudokuSolver {
	
    
    // Lailani
    public boolean BFSsolver() {
        return BFS_solver();
    }
	
	// Lailani
	public static boolean BFS_solver() {
		// BFS logic
		return false;	
	}
    
    
   
    // Solve the Sudoku puzzle using DFS and backtracking
    // Mercedes 
	// input should be the board
	private static boolean solveBoard(int[][] board) {
	    for (int row = 0; row < 9; row++) {
	      for (int column = 0; column < 9; column++) {
	        if (board[row][column] == 0) {
	          for (int numberToTry = 1; numberToTry <= 9; numberToTry++) {
	            if (isValid(board, numberToTry, row, column)) {
	              board[row][column] = numberToTry;
	              
	              if (solveBoard(board)) {
	                return true;
	              }
	              else {
	                board[row][column] = 0;
	              }
	            }
	          }
	          return false;
	        }
	      }
	    }
	    return true;
	  }
    
    // Mercedes
 	public static boolean DFS_solver() {
 		// setting cell instance
 		Cell curr = SudokuGraphBuilder.emptyCellFinder();
 		
 		// puzzle was solved
 		if (curr == null) {
 			return true;
 		}
 		
 		// DFS solving logic
 		int col = curr.getCol();
 		int row = curr.getRow();
 		
 		// for values 1-9 try them in board code referenced from ChatGPT
 		for (int value=1; value< 10 ; value++) {
 			// if it works place value in cell
 			if (isValid(col, row, value) == true) {
 				curr.setValue(value);
 				
 				// if the rest of the board is solvable
 				if (DFS_solver(board) == true) {
 					// board is solved 
 					return true;
 				} else {
 					// backtrack
 					curr.setValue(0);
 				}
 			}
 		}
 		
 		return false;	
 	}
    					
	// checks if number is valid
	static boolean isValid(int [][]board, int value, int row, int col) {
		// find if number is in columns neighbors 
		for (int colNum=0; colNum<9; colNum++) {
			if (board.getCellNum(row, col) == value) {
				// if found return false 
				return false;
			}
		}
		
		// find if number is in rows neighbors 
		for (int rowNum=0; rowNum<9; rowNum++) {
			if (board.getCellNum(row, col) == value) {
				// if found return false 
				return false;
			}
		}
	
		// find box numbers code from: https://www.youtube.com/watch?v=mcXc8Mva2bA
		int localBoxRow = row - row % 3;
		int localBoxCol = col - col % 3;
		
		for (int i = localBoxRow; i < localBoxRow + 3; i++) {
			for(int j = localBoxCol; i <localBoxCol + 3; j++) {
				if (board.getCellNum(row, col) == value) {
					// if found return false 
					return false;
				}
			}
		}
		
		// value wasn't a neighbor meaning its valid
		return true;
		
	}
	
	
	
}
