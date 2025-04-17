package sudokuSolver;


/** 
* 
* Class that produces sudoku board solutions
* April 17, 2025
*/


public class PuzzleSolver {
	public static void solver(String[] args) {
		
		

		
	}
        
   
	static void puzzleSolver(SudokuBoard board) {
		// variable tracking column and row number
		int rowNum = 0;
		int columnNum = 0;
		
		// traversing the board
		while (rowNum <= 8) {
			System.out.println(board.getCell());
			// NUMBER CELL CASES
			if (board.getCell() != 0) {
				if (columnNum == 8 && rowNum != 8) {
					// MOVER - cell tracker at end of row
					rowNum++;
					columnNum = 0;
					board.moveTo(rowNum, columnNum);
				} else if (columnNum != 8) {
					// MOVER - cell tracker in middle of row 
					columnNum++;
					board.moveTo(rowNum, columnNum);
				} else {
					// solved 
					System.out.println("finished"); 
					break;
				}
			// EMPTY CELL CASES
			} else if (board.getCell() == 0){
				
				
				
				
				
				
				if (columnNum == 8 && rowNum != 8) {
					int newValue = valueChanger(board);
					// MOVER- cell tracker at end of row
					rowNum++;
					columnNum = 0;
					board.moveTo(rowNum, columnNum);
				} else if (columnNum != 8) {
					
					// MOVER - cell tracker in middle of row 
					columnNum++;
					board.moveTo(rowNum, columnNum);
				} else {
					// solved
					System.out.println("finished");
					break;
				}
				
			}
			
		}
							
		}
	
	static boolean isValid() {
		if (validRow() == false) {
			return false;
		}
		
		if (validBox() == false) {
			return false;
		}
		
		if (validColumn() == false) {
			return false;
		}
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
	
	// find value for cell
	static int valueChanger(SudokuBoard board) {
		for (int n = 1; n <= 9; n++) {
			board.setCell(n);
			if (isValid() == true) {
				break;
			} else {
				board.setCell(valueChanger(board));
			}
			
		}
		return 0;	
		
	}
	
	// will use later on maybe make it like a row and column seperatation 
	static void mover(SudokuBoard board, int rowNum, int columnNum) {
		System.out.println(board.getCell());
		// NUMBER CELL CASES
		if (board.getCell() != 0) {
			if (columnNum == 8 && rowNum != 8) {
				// MOVER - cell tracker at end of row
				rowNum++;
				columnNum = 0;
				board.moveTo(rowNum, columnNum);
			} else if (columnNum != 8) {
				// MOVER - cell tracker in middle of row 
				columnNum++;
				board.moveTo(rowNum, columnNum);
			} else {
				// solved 
				System.out.println("finished"); 
			}
		// EMPTY CELL CASES
		} else if (board.getCell() == 0){
			if (columnNum == 8 && rowNum != 8) {
				
				// MOVER- cell tracker at end of row
				rowNum++;
				columnNum = 0;
				board.moveTo(rowNum, columnNum);
			} else if (columnNum != 8) {
				
				// MOVER - cell tracker in middle of row 
				columnNum++;
				board.moveTo(rowNum, columnNum);
			} else {
				// solved
				System.out.println("finished");
			}
			
		}
		
	}

}
