package sudokuSolver;

import java.util.List;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;



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
	// Variable tracking solutions
	static int solutionCount = 0;
	// queue for BFS
	static Queue<Graph<Vertex>> boardHolder = new LinkedList<>();
	
    
    // Lailani
	public static void BFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		cell = findingEmptyCell(cell, sudokuGraph);
		
		for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
			// if number is valid set cells value
			if (isValid(cell, PosNumber, sudokuGraph) == true) {
				// set valid value
				cell.setValue(PosNumber);
				
				// copy valid board 
				Graph<Vertex> clonedBoard = sudokuGraph.clone();
				// add to queue of valid boards 
				boardHolder.add(clonedBoard);
				
				return;
			}
		}
		
		// check for solved boards
	    Iterator<Graph<Vertex>> iter = boardHolder.iterator();
	    // iterate through boards in iter
	    while (iter.hasNext()) {
	    	Graph<Vertex> board = iter.next();
	    	
	    	// go through vertex's in  each board
	    	for (Vertex vertex : board) {
	    		// if there is an error remove it from queue holding valid boards
	    		if (isValid(vertex, vertex.getValue(), board) == false) {
	    			iter.remove();
	    			break;
	    		}
	    	}	
	    }
		
		
		
    }
	
	// Mercedes
	// Solve the Sudoku puzzle using DFS and backtracking
	// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
	public static void DFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		cell = findingEmptyCell(cell, sudokuGraph);
		// solved it or no cells left
		if (cell == null) {	
			// increasing solutions counter 		
			solutionCount++;
			// printing solved board
			BoardBuilder.printSudokuGraph(sudokuGraph);
			// print number of solutions found 
			System.out.println("\nsolutions found: " + solutionCount);
			return;
		}
		// tries placing numbers 1-9
		for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
			// if number is valid set cells value
			if (isValid(cell, PosNumber, sudokuGraph) == true) {
				// set valid value
				cell.setValue(PosNumber);
				// call recursive function
				DFS_solveBoard(cell, sudokuGraph);
				// Backtrack 
	            cell.setValue(0);
			}
			
		}
			
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
