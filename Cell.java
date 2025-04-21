package sudokuSolver;


/** 
* 
* Cell Class for Sudoku Board
* April 21, 2025
*/


import java.util.*;
// code from chatGPT
public class Cell {
    // variables
	// row and column locations 
	int row, col;
	// value 0-9
	int value;

    public Cell(int r, int c) {
        // cell class constructor
    	this.row = r;
        this.col = c;
        this.value = 0;
    }
    
    // get row
    public int getRow() {
        return row;
    }

    // set row
    public void setRow(int row) {
        this.row = row;
    }

    // get column 
    public int getCol() {
        return col;
    }

    // set column 
    public void setCol(int col) {
        this.col = col;
    }
    
    // get value
    public int getValue() {
        return value;
    }

    // set value
    public void setValue(int v) {
        this.value = v;
    }

    // methods
    @Override
    public boolean equals(Object obj) {
        // method to check if two cells are the same number
    	if (!(obj instanceof Cell)) return false;
        Cell other = (Cell) obj;
        return this.row == other.row && this.col == other.col;
    }

    @Override
    // method to insure two equal cells have the same hash
    public int hashCode() {
    	return Objects.hash(row, col);
    }
}
