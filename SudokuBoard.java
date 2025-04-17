package sudokuSolver;

/** 
* 
* Class that builds 9x9 Sudoku Puzzle
* April 17, 2025
*/

// Code from ChatGPT
public class SudokuBoard {
    private Cell[][] board;
    // current cell
    private Cell pos; 

    // Constructor to initialize the board with empty cells
    public SudokuBoard() {
        board = new Cell[9][9];

        // Initialize all the cells in the board with row and col
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board[row][col] = new Cell(row, col);
            }
        }
        // Initialize the beginning cell position
        pos = board[0][0];
    }

    // Method to set the numbers in sudoku board
    public void setCellNum(int row, int col, int num) {
    	// Set the number in the cell
    	board[row][col].setNum(num);  
    }
    
    // move to different cell on board
    public void moveTo(int row, int col) {
		pos = board[row][col];
	}

    // get the number of the current cell
	public int getCellNum() {
		return pos.getNum(); 
	}

    // Method to print the board 
    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col].getNum() + " ");  
            }
            System.out.println();  
        }
    }
}
