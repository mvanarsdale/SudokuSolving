package sudokuSolver;
import java.util.Objects;

class Vertex {
    int row, col, layer, value;

    Vertex(int row, int col, int value) {
        // int value of row
    	this.row = row;
    	// int value of column
    	this.col = col;
    	// layer for 3D
    	this.layer = layer;
    	// int value of the number at coordinate 
    	this.value = value;
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
    // method to compare two vertex values
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex v = (Vertex) o;
        return row == v.row && col == v.col;
    }

    @Override
    // method to ensure coordinates are handled correctly
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    // toString method
    public String toString() {
        return "(" + row + "," + col + ")";
    }
}

