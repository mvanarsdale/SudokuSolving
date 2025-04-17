package sudokuSolver;

public class PuzzleSolver {
	public static void solver(String[] args) {
		
	}
        
     
	
	static void puzzleSolver(SudokuBoard board) {
		int rowNum = 0;
		int columnNum = 0;
		
		while (columnNum != 8 && rowNum != 8) {
			if (board.getCell() == 0) {
				if (columnNum == 8 && rowNum != 8) {
					// cell tracker at end of row
					rowNum++;
					columnNum = 0;
					board.moveTo(rowNum, columnNum);
				} else if (columnNum != 8) {
					// cell tracker in middle of row 
					columnNum++;
					board.moveTo(rowNum, columnNum);
				} else {
					// solved end of puzzle reached 
					continue;
				}
					
			}
					
				
			
				
		}
		
		
	}

	}
