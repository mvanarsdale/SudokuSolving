package sudokuSolver;



/** 
* Sudoku board builder for 3D graphs
* @author (Mercedes)
* @version (2025)
*/

// libraries 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BoardBuilder_3D {

	// file reader method from ChatGPT
	public static void load3DBoardFromFile(String fileName, Graph<Vertex> sudokuGraph_3D) {
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line;
	        int row = 0;
	        
	        // track which layer 
	        int layer = 0;
	        
	        // reads lines in txt file
	        while ((line = reader.readLine()) != null) {
	            // Skip empty lines
	            if (line.trim().isEmpty()) {
	                continue;
	            }
	            // puts numbers into an array splitting by the spaces
	            String[] numbers = line.split("\\s+");
	            
	            for (int col = 0; col < 9; col++) {
	            	// removes surrounding spaces
	            	String numStr = numbers[col].trim(); 
	            	// converts string to a integer
	                int num = Integer.parseInt(numStr);       
	                // create vertex in graph
	                Vertex cell = new Vertex(row, col, layer, num);
	                // Add the vertex to the graph
	                sudokuGraph_3D.addVertex(cell);
	                // cals method (for 2D graphs) to add edges between neighbors
	                addEdgesToCell3D(cell, sudokuGraph_3D);
	            }
	            // Iterate to the next row
	            row++; 
	            
	            // Added 3D logic - go to next layer once last row is filled
	            if (row == 9) {
	                row = 0;
	                layer++;
	            }
	        }
	        // close reader
	        reader.close();
	     // handles errors 
	    } catch (IOException e) {
	        System.err.println("Error reading file: " + e.getMessage());
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing number: " + e.getMessage());
	    }
	}
	
	// add edges between cells in the same row, column, box
	// 3D enhancement method
	public static void addEdgesToCell3D(Vertex cell, Graph<Vertex> sudokuGraph_3D) {
	    int row = cell.row;
	    int col = cell.col;
	    int layer = cell.layer;

	    // Go through all vertices in the graph to find neighbors code from ChatGPT
	    for (Vertex other : sudokuGraph_3D.map.keySet()) {
	        if (other == cell) continue;

	        // checks if cells are on same layer 
	        boolean sameLayer = other.layer == layer;
	        
	        // checks value of current cell and compares to others in the same row
	        boolean sameRow = sameLayer && other.row == row;
	        // checks value of current cell and compares to others in the same column
	        boolean sameCol = sameLayer && other.col == col;
	        // checks value of current cell and compares to others in the same box
	        boolean sameBox = sameLayer && (other.row / 3 == row / 3) && (other.col / 3 == col / 3);
	       
	        // 3D checks value of current cell and compares to others in different layers with the same coordinates 
	        boolean layerNeighbor = (other.col == col && other.row == row && other.layer != layer);

	        // if its a neighbor to the node in any way
	        if (sameRow || sameCol || sameBox || layerNeighbor) {
	            // add an edge between nodes
	        	sudokuGraph_3D.addEdge(cell, other, true); 
	        }
	    }
	}

	// 3D printing function from ChatGPT
	public static void print3DSudokuGraph(Graph<Vertex> sudokuGraph_3D) {
		// specfic to sudoku puzzles with 3 layers
	    for (int layer = 0; layer < 3; layer++) {
	        System.out.println("Layer " + layer + ":");
	        // for each of the boards
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                // initalize the cell as being empty
	            	boolean found = false;
	                // look through each vertex in the graph
	            	for (Vertex v : sudokuGraph_3D.map.keySet()) {
	            		if (v.row == row && v.col == col && v.layer == layer) {
	                        System.out.print((v.value == 0 ? ". " : v.value + " "));
	                        // change if cell has a number value 
	                        found = true;
	                        break;
	                    }
	                }
	            	// for empty cells
	                if (!found) {
	                    System.out.print(". ");
	                }
	                // Box separator for columns
	                if (col % 3 == 2 && col != 8) {
	                    // cosmetics 
	                	System.out.print("| ");
	                }
	            }
	            System.out.println();
	            // Box separator for rows
	            if (row % 3 == 2 && row != 8) {
	                System.out.println("------+-------+------");
	            }
	        }
	        // space layers
	        System.out.println(); 
	    }
	}

    public static void main(String[] args) {
        // Object of graph is created
        Graph<Vertex> sudokuGraph_3D = new Graph<>();
        

        // Read the Sudoku grid from a file 
        
        // easy puzzle file - puzzle generated from ChatGPT
        load3DBoardFromFile("3D_easy.txt", sudokuGraph_3D);
        
        // medium puzzle file - puzzle generated from ChatGPT
        //load3DBoardFromFile("3D_medium.txt", sudokuGraph_3D);
        
        /// hard puzzle file - puzzle generated from ChatGPT
        //load3DBoardFromFile("3D_hard.txt", sudokuGraph_3D);
        
        // spacer
        System.out.println("Puzzle");
        
        // Print the graph 
        print3DSudokuGraph(sudokuGraph_3D);
        
        // solution
        System.out.println("\n++++++SOLUTION+++++++");
        print3DSudokuGraph(sudokuGraph_3D);
        
        Vertex startCell = SudokuSolver.findEmptyCell(sudokuGraph_3D);
        if (startCell != null) {
            SudokuSolver.DLS_solveBoard3D(sudokuGraph_3D, startCell);
            //SudokuSolver.BFS_solveBoard(startCell, sudokuGraph);
        }
   }  
}