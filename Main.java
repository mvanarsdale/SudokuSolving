package sudokuSolver;

/** 
* 
* Main class for sudoku solver
* April 17, 2025
*/


public class Main {
    public static void main(String[] args) {
    	// create board instance 
        SudokuBoard board = new SudokuBoard();
        
        // board from first GitHub puzzle
        board.setCellNum(0, 0, 5);
        board.setCellNum(0, 1, 3);
        board.setCellNum(0, 4, 7);
        board.setCellNum(1, 0, 6);
        board.setCellNum(1, 3, 1);
        board.setCellNum(1, 4, 9);
        board.setCellNum(1, 5, 5);
        board.setCellNum(2, 1, 9);
        board.setCellNum(2, 2, 8);
        board.setCellNum(2, 7, 6);
        board.setCellNum(3, 0, 8);
        board.setCellNum(3, 4, 6);
        board.setCellNum(3, 8, 3);
        board.setCellNum(4, 0, 4);
        board.setCellNum(4, 3, 8);
        board.setCellNum(4, 5, 3);
        board.setCellNum(4, 8, 1);
        board.setCellNum(5, 0, 7);
        board.setCellNum(5, 4, 2);
        board.setCellNum(5, 8, 6);
        board.setCellNum(6, 1, 6);
        board.setCellNum(6, 6, 2);
        board.setCellNum(6, 7, 8);
        board.setCellNum(7, 3, 4);
        board.setCellNum(7, 4, 1);
        board.setCellNum(7, 5, 9);
        board.setCellNum(7, 8, 5);
        board.setCellNum(8, 4, 8);
        board.setCellNum(8, 7, 7);
        board.setCellNum(8, 8, 9);
       
        // printing function from SudokuBoard class
        board.printBoard();  
    }
}


