package sudokuSolver;


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
    public boolean DFSsolver() {
        return DFS_solver();
    }
    
    // Mercedes
 	public static boolean DFS_solver() {
 		// setting cell instance
 		Cell curr = SudokuGraphBuilder.emptyCellFinder();
 		
 		// puzzle was solved
 		if (curr == null) {
 			return true;
 		}
 		
 		return false;	
 	}
    
						
	// checks if number is valid
	static boolean isValid() {
		// calls method to check if number is in cells row
		if (validRow() == false) {
			// if so return false 
			return false;
		}
		// calls method that checks if number is in box numbers
		if (validBox() == false) {
			// if so return false 
			return false;
		}
		// calls method that checks if number is in cells column neighbors
		if (validColumn() == false) {
			// if so return false 
			return false;
		}
		// Satisfies all conditions 
		return true;
		
	}
	
	// check if row is valid
	static boolean validRow() {
		return false;
		
	}
	
	// check if box is valid 
	static boolean validBox() {
		return false;
		
	}
	
	// check if column is valid
	static boolean validColumn() {
		return false;
		
	}
	
}
