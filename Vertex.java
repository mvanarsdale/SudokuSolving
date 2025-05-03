package sudokuSolver;


/** 
* Vertex class for graph
* @author ()
* @version (2025)
*/


//libraries
import java.util.Objects;

class Vertex {
    int row, col, layer, value;

    Vertex(int row, int col, int layer, int value) {
        // int value of row
    	this.row = row;
    	// int value of column
    	this.col = col;
    	// int value of the number at coordinate 
    	this.value = value;
    	// int value for layer 
    	this.layer = layer;
    }
    
    // for 2D boards
    Vertex(int row, int col, int value) {
    	// layer 0 for 2D b
    	this(row, col, 0, value); 
    }
    
    // row getter
    public int getRow() { 
    	return this.row; 
    }
    
    // column getter
    public int getCol() {
    	return this.col; 
    }
    
    // layer getter for 3D puzzles
    public int getLayer() {
    	return this.layer; 
    }
    
    // value getter
    public int getValue() { 
    	return value; 
    }
    
    // value setter
    public void setValue(int value) {
    	this.value = value; 
    }

    @Override
    // code from ChatGPT - overrides equals function to compared vertices
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex v = (Vertex) o;
        return row == v.row && col == v.col && layer == v.layer;
    }

    @Override
    // code from ChatGPT - method to ensure coordinates are handled correctly
    public int hashCode() {
        return Objects.hash(row, col, layer);
    }
}

