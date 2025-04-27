package sudokuSolver;

import java.util.List;

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
	// Solve the Sudoku puzzle using DFS and backtracking
	// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
	public static boolean DFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		cell = findingEmptyCell(cell, sudokuGraph);
		// solved it or no cells left
		if (cell == null) {	
			// printing solved board
			//System.out.println("_______________________");
			BoardBuilder.printSudokuGraph(sudokuGraph);
			
			return true; 
		}
		
		// tries placing numbers 1-9
		for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
			// if number is valid set cells value
			if (isValid(cell, PosNumber, sudokuGraph) == true) {
				cell.setValue(PosNumber);
				//BoardBuilder.printSudokuGraph(sudokuGraph);
				
				// check overall solution
				if (DFS_solveBoard(cell, sudokuGraph)) {
					return true;
				}
			}
			// Backtrack
            cell.setValue(0);
		}
		
		// no solution
		return false;		
	}
		
		
	// finding empty cell in the board
	static Vertex findingEmptyCell(Vertex cell, Graph<Vertex> sudokuGraph) {
		// column and row variables
		int col = cell.col;
		int row = cell.row;
		
		// end of the row hasn't been reached
		while (col < 9) {
			// if value is 0 that means its empty
			if (Graph.getVertexAt(row, col, sudokuGraph.map).getValue() == 0) {
	            // return empty cell
				return Graph.getVertexAt(row, col, sudokuGraph.map);
	        }
			// move over horizontally
			col++;
			// checks if moved to far
			if (col == 9) {
				// resets accordingly
				col = 0;
				row++;
			}
			// returns null if gone through whole board
			if (row == 9) {
				return null;
			}
		}
    return null;
	}
    
	// checks if number value is in current cells neighbors 
	static boolean isValid(Vertex cell, int number, Graph<Vertex> sudokuGraph) {
		// get list of neighboring nodes
		List<Vertex> neighbors = sudokuGraph.neighbours(cell); 
	    
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
