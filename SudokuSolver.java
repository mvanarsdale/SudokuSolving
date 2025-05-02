package sudokuSolver;


// libraries 
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


/** 
* Class that produces sudoku board solutions using a DLS and BFS approach 
* @author ()
* @version (2025)
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
	
    
	public static void BFS_solveBoard(Vertex cell, Graph<Vertex> sudokuGraph) {
		// add initial board in queue
		boardHolder.add(sudokuGraph);

		// while queue has boards
		while (!boardHolder.isEmpty()) {
			// board removed from the queue
			Graph<Vertex> board = boardHolder.poll();
			// find empty cell in that board
			Vertex emptyCell = findEmptyCell(board);
			
			// board has been finished and solved
		    if (emptyCell == null) {
		    	// update solutions counter variable
		    	solutionCount++;
		    	// print solutions # 
		    	System.out.println("\nsolutions found: " + solutionCount);
		    	// printing solved board
				BoardBuilder.printSudokuGraph(sudokuGraph);
		        continue;
		    }
		    for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
		    	// if number is valid set cells value
		    	if (isValid(emptyCell, PosNumber, board) == true) {	    
		    		// copy valid board 
		    		Graph<Vertex> clonedBoard = board.cloneGraph();
		    		// set valid value
		    		emptyCell.setValue(PosNumber);
		    		// add to queue of valid boards 
		    		boardHolder.add(clonedBoard);
		    	}
		    }
		}
   }

	// Solve the Sudoku puzzle using DFS and backtracking
	// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
	public static void DFS_solveBoard(Graph<Vertex> sudokuGraph) {
		Vertex cell = findEmptyCell(sudokuGraph);
		// solved it or no cells left
		if (cell == null) {
			// increasing solutions counter 		
			solutionCount++;
			// print number of solutions found 
			System.out.println("\nsolutions found: " + solutionCount);
			BoardBuilder.printSudokuGraph(sudokuGraph);
			return;
		}
		// tries placing numbers 1-9
		for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
			// if number is valid set cells value
			if (isValid(cell, PosNumber, sudokuGraph) == true) {
				// set valid value
				cell.setValue(PosNumber);
				// call recursive function
				DFS_solveBoard(sudokuGraph);
				// Backtrack 
	            cell.setValue(0);
			}
		}	
	}
	
	// Solve the Sudoku puzzle using DFS and backtracking
		// code referenced from: YT@Coding with John [https://www.youtube.com/watch?v=mcXc8Mva2bA]
		public static void DFS_solveBoard3D(Graph<Vertex> sudokuGraph_3D, Vertex cell) {
			// solved it or no cells left
			if (cell == null) {
				// increasing solutions counter 		
				solutionCount++;
				// print number of solutions found 
				System.out.println("\nsolutions found: " + solutionCount);
				BoardBuilder.printSudokuGraph(sudokuGraph_3D);
				return;
			}
			// tries placing numbers 1-9
			for (int PosNumber = 1; PosNumber <= 9; PosNumber++) {
				// if number is valid set cells value
				if (isValid(cell, PosNumber, sudokuGraph_3D) == true) {
					
					// set valid value
					cell.setValue(PosNumber);
					BoardBuilder_3D.print3DSudokuGraph(sudokuGraph_3D);
					//System.out.println("Trying " + PosNumber + " at (" + cell.layer + "," + cell.row + "," + cell.col + ")");
					
					// call recursive function
					DFS_solveBoard3D(sudokuGraph_3D, findEmptyCell(sudokuGraph_3D));
					// Backtrack 
		            cell.setValue(0);
				}
			}	
		}
	
	// Lailani - finds the first empty cell on the board 
	static Vertex findEmptyCell(Graph<Vertex> board) {
		// for each cell in diff layer
		for (int layer = 0; layer < 9; layer++) {
			// for each cell in diff row
			for (int row = 0; row < 9; row++) {
				// for each cell in diff row
				for (int col = 0; col < 9; col++) {
					// get the vertex/cell
					Vertex v = Graph.get3DVertexAt(row, col, layer, board.map);
					// check if its empty 
					if (v != null && v.getValue() == 0) {
						//System.out.println("Found empty cell at Layer " + layer + ", Row " + row + ", Col " + col);
						// return if empty
						return v;
					}
				}
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
