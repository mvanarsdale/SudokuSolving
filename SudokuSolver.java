package sudokuSolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** 
* 
* Class that produces sudoku board solutions
* April 21, 2025
*/



/** 
* This solution approach was referenced from:
* 
* Lina, Tirsa & Rumetna, Matheus. (2021).
* Comparison Analysis of Breadth First Search and Depth Limited Search Algorithms in Sudoku Game. 
* Bulletin of Computer Science and Electrical Engineering.2. 74-83. 10.25008/bcsee.v2i2.1146. 
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
    
    
  
    // Mercedes 
	// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
	// Solve the Sudoku puzzle using DFS and backtracking
	public boolean DFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		// solved it or no cells left
		if (cell == null) {	
			return true; 
		}
		// cell is empty
		cell = findingEmptyCell(cell, sudokuGraph);
		if (cell != null) {
			for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
				if (isValid(cell, PosNumber, sudokuGraph) == true) {
					cell.setValue(PosNumber);
				} else {
					DFS_solveBoard(cell, sudokuGraph);
				}
				
			}
		}		
	}
		
		
	Vertex findingEmptyCell(Vertex cell, Graph<Vertex> sudokuGraph) {
		if (cell.getValue() == 0) {
			return cell; 
		} else {
		
		// column and row variables
		int col = cell.col;
		int row = cell.row;
		
		// if cell is placed before end of row
		if (col < 8) {
			col++;
		}
		
		// cell is at the end of the row
		if (row == 8) {
			col = 0;
			row++;
		}
		
		// move cell to find next zero value
		cell = findingEmptyCell(Graph.getVertexAt(row, col, sudokuGraph.map), sudokuGraph);
		
		}
}
    
	boolean isValid(Vertex cell, int number, Graph<Vertex> sudokuGraph) {
		List<Vertex> neighbors = sudokuGraph.neighbours(cell); // get da neighbors (o´ω｀o)
	    
		// check neighbors of the cell
	    for (Vertex neighbor : neighbors) {
	    	if (neighbor.getValue() == number) { 
	            // can't place the number is in neighbors
	        	return false;
	        }
	    }
	    // no neighbor with that value
	    return true; 
	}
}
	
	

}
