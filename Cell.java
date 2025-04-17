package sudokuSolver;

/** 
* 
* Cell Class for Sudoku Board
* April 17, 2025
*/


public class Cell {
	// Initialize cell to be "empty"
	public int num = 0;
	
	public Cell(int row, int col) {
        // Initialize cell to be "empty"
        this.num = 0;
    }
	
	// method to set number value of cell
	public void setNum(int n) {
		this.num = n;
	}
	
	// method to get cells number value
	public int getNum() {
		return this.num;
	}
	

}
