package sudokuSolver;


/** 
* 
* Class that builds a sudoku board
* April 21, 2025
*/

// libraries 
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class SudokuGraphBuilder {
    private static Map<Cell, Set<Cell>> graph = new HashMap<>();

    // Method to build the graph
    public Map<Cell, Set<Cell>> buildGraph() {
        // Initialize the graph with all cells and their neighbors Code from ChatGPT
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell current = new Cell(row, col);
                Set<Cell> neighbors = new HashSet<>();
                // Row & Column neighbors
                for (int i = 0; i < 9; i++) {
                    // row neighbors
                    if (i != col) neighbors.add(new Cell(row, i));
                    // column neighbors
                    if (i != row) neighbors.add(new Cell(i, col));
                }
                // box neighbors
                int boxStartRow = (row / 3) * 3;
                int boxStartCol = (col / 3) * 3;
                for (int r = boxStartRow; r < boxStartRow + 3; r++) {
                    for (int c = boxStartCol; c < boxStartCol + 3; c++) {
                        if (r != row || c != col) {
                            neighbors.add(new Cell(r, c));
                        }
                    }
                }
                // Add neighbors to hash map
                graph.put(current, neighbors);
            }
        }
        return graph;
    }

    // set the value of a specific cell code from ChatGPT
    public void setCellNum(int row, int col, int value) {
        for (Cell cell : graph.keySet()) {
            if (cell.getRow() == row && cell.getCol() == col) {
                cell.setValue(value); // Set value in the cell (node)
                break;
            }
        }
    }

    // Get the value of a specific cell Code from ChatGPT
    public int getCellNum(int row, int col) {
        for (Cell cell : graph.keySet()) {
            if (cell.getRow() == row && cell.getCol() == col) {
            	// Get value from the cell
            	return cell.getValue();
            }
        }
        return 0;
    }
    
    // method to find empty cells on the board 
    public static Cell emptyCellFinder() {
		// iterate through cells in graph hash map
    	for (Cell cell : graph.keySet()) {
			// return cell if empty
    		if (cell.getValue() == 0) {
				return cell;
			}
		}
    	// puzzle is finished 
		return null;
    }

    // method to print the board {debugging} method from ChatGPT
    public void printBoard() {
        for (int row = 0; row < 9; row++) {
            // visually separate every three rows 
        	if (row % 3 == 0 && row != 0) {
                System.out.println("------+-------+------");
            }
            for (int col = 0; col < 9; col++) {
            	// visually separate every three columns
            	if (col % 3 == 0 && col != 0) {
                    System.out.print("| ");
                }
            	// prints values 
                int value = getCellNum(row, col); // Get value from the graph (node)
                System.out.print(value == 0 ? ". " : value + " ");
            }
            System.out.println();
        }
    }
}
