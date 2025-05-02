package sudokuSolver;

/** 
* Sudoku Solver for 3D puzzles
*/


import java.io.*;

public class BoardBuilder {

	// file reader method from ChatGPT
	public static void loadBoardFromFile(String fileName, Graph<Vertex> sudokuGraph) {
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        String line;
	        int row = 0;

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
	                Vertex cell = new Vertex(row, col, num);

	                // Add the vertex to the graph
	                sudokuGraph.addVertex(cell);

	                // cals method (for 2D graphs) to add edges between neighbors
	                addEdgesToCell(cell, sudokuGraph);
	            }

	            // Iterate to the next row
	            row++; 
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


    // add edges between cells in the same row, column, and box
	public static void addEdgesToCell(Vertex cell, Graph<Vertex> sudokuGraph) {
	    int row = cell.row;
	    int col = cell.col;

	    // Go through all vertices in the graph to find neighbors code from ChatGPT
	    for (Vertex other : sudokuGraph.map.keySet()) {
	        if (other == cell) continue;

	        // checks value of current cell and compares to others in the same row
	        boolean sameRow = other.row == row;
	        // checks value of current cell and compares to others in the same column
	        boolean sameCol = other.col == col;
	        // checks value of current cell and compares to others in the same box
	        boolean sameBox = (other.row / 3 == row / 3) && (other.col / 3 == col / 3);
	       

	        // if its a neighbor to the node in any way
	        if (sameRow || sameCol || sameBox) {
	            // add an edge between nodes
	        	sudokuGraph.addEdge(cell, other, true); 
	        }
	    }
	}
	
	// add edges between cells in the same row, column, box
	// added 3D enhancement 
	public static void addEdgesToCell3D(Vertex cell, Graph<Vertex> sudokuGraph) {
	    int row = cell.row;
	    int col = cell.col;
	    int layer = cell.layer;

	    // Go through all vertices in the graph to find neighbors code from ChatGPT
	    for (Vertex other : sudokuGraph.map.keySet()) {
	        if (other == cell) continue;

	        // checks value of current cell and compares to others in the same row
	        boolean sameRow = other.row == row;
	        // checks value of current cell and compares to others in the same column
	        boolean sameCol = other.col == col;
	        // checks value of current cell and compares to others in the same box
	        boolean sameBox = (other.row / 3 == row / 3) && (other.col / 3 == col / 3);
	        // 3D checks value of current cell and compares to others in different layers with the same coordinates 
	        boolean layerNeighbors = (other.col == col && other.row == row && other.layer != layer);

	        // if its a neighbor to the node in any way
	        if (sameRow || sameCol || sameBox || layerNeighbors) {
	            // add an edge between nodes
	        	sudokuGraph.addEdge(cell, other, true); 
	        }
	    }
	}
    
    
    // printing function from ChatGPT for debugging
    public static void printSudokuGraph(Graph<Vertex> sudokuGraph) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                
                boolean found = false;

                for (Vertex v : sudokuGraph.map.keySet()) {
                    if (v.row == row && v.col == col) {
                        System.out.print((v.value == 0 ? ". " : v.value + " "));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.print(". ");
                }
                // Add vertical box separator
                if (col % 3 == 2 && col != 8) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            // Add horizontal box separator
            if (row % 3 == 2 && row != 8) {
                System.out.println("------+-------+------");
            }
        }
    }


    public static void main(String[] args) {
        // Object of graph is created
        Graph<Vertex> sudokuGraph = new Graph<>();
        
        //Graph<Vertex> dfsGraph = sudokuGraph.cloneGraph();
        //Graph<Vertex> bfsGraph = sudokuGraph.cloneGraph();
        

        ////////// Replace "sudoku_puzzle_1" with 2-Med or 3-Hard /////////////////
        // Read the Sudoku grid from a file - Easy 
        loadBoardFromFile("sudoku_puzzle_3.txt", sudokuGraph);
        // difficulty
        System.out.println("Puzzle");
        // Print the graph 
        printSudokuGraph(sudokuGraph);
        
        // solution
        System.out.println("\nSolution");
        
        Vertex startCell = Graph.getVertexAt(0, 0, 0, sudokuGraph.map);
        if (startCell != null) {
            SudokuSolver.DFS_solveBoard(startCell, sudokuGraph);
            //SudokuSolver.BFS_solveBoard(startCell, sudokuGraph);
        }
   }  
}
