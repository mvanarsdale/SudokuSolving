package sudokuSolver;

/** 
* 
* Sudoku puzzle board class
* April 15, 2025
*/

// sudoku board class from ChatGPT
public class SudokuBoard {
    // 2D array for the board
	private int[][] board;
	
	private int currRow;
    private int currCol;

	// sudoku board constructor 
    public SudokuBoard(int[][] initialBoard) {
        // 9 by 9
    	this.board = initialBoard;
    	
    }
    
    // Moves the pointer to a new position
    public void moveTo(int row, int col) {
        currRow = row;
        currCol = col;
    }

    // Returns value at the current cell 
    public int getCell() {
        return board[currRow][currCol];  
    }

    // Sets value at the current cell 
    public void setCell(int value) {
        board[currRow][currCol] = value;
    }

    // method to print board 
    public void printBoard() {
    	for (int i = 0; i < 9; i++) {
    		// Visually separate every three rows
    		if (i % 3 == 0 && i != 0)
                System.out.println("- - - - - - - - - - -");
    		for (int j = 0; j < 9; j++) {
    			// Visually separate every three columns 
    			if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(board[i][j] == 0 ? ". " : board[i][j] + " ");
            }
            System.out.println();
        }
    }
}