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
	// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
	// Solve the Sudoku puzzle using DFS and backtracking
	public static boolean DFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		cell = findingEmptyCell(cell, sudokuGraph);
		// solved it or no cells left
		if (cell == null) {	
			// printing solved board
			BoardBuilder.printSudokuGraph(sudokuGraph);
			
			return true; 
		}
		
		
		for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
			if (isValid(cell, PosNumber, sudokuGraph) == true) {
				cell.setValue(PosNumber);
				//BoardBuilder.printSudokuGraph(sudokuGraph);
				
			 
			
				if (DFS_solveBoard(cell, sudokuGraph)) {
					return true;
				}
			}
			
			// Backtrack if error appears later
            cell.setValue(0);
	
		}
		
		// no solution
		return false;		
	}
		
		
	// finding next empty cell in the board
	static Vertex findingEmptyCell(Vertex cell, Graph<Vertex> sudokuGraph) {
		
		// column and row variables
		int col = cell.col;
		int row = cell.row;
		
		// end of the row hasnt been reached
		while (row < 9) {
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
		}
    return null;
	}
	
	// code to find first empty cell from chatGPT
	public static Vertex findFirstEmptyCell(Graph<Vertex> sudokuGraph) {
	    for (Vertex v : sudokuGraph.map.keySet()) {
	        if (v.getValue() == 0) {
	        	// found empty cell
	        	return v; 
	        }
	    }
	    // reached end of board 
	    return null; 
	}
    
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
