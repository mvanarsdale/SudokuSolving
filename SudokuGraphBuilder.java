package sudokuSolver;


/** 
* 
* Class that builds 9x9 Sudoku Puzzle
* April 21, 2025
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// code from ChatGPT
public class SudokuGraphBuilder {
    // Graph represented as a map from Cell to its neighboring cells (edges)
    private Map<Cell, Set<Cell>> graph = new HashMap<>();

    // Method to build the graph
    public Map<Cell, Set<Cell>> buildGraph() {
        // Initialize the graph with all cells and their neighbors
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

                // Add neighbors to graph
                graph.put(current, neighbors);
            }
        }
        return graph;
    }

    // set the value of a specific cell 
    public void setCellNum(int row, int col, int value) {
        for (Cell cell : graph.keySet()) {
            if (cell.getRow() == row && cell.getCol() == col) {
                cell.setValue(value); // Set value in the cell (node)
                break;
            }
        }
    }

    // Get the value of a specific cell
    public int getCellNum(int row, int col) {
        for (Cell cell : graph.keySet()) {
            if (cell.getRow() == row && cell.getCol() == col) {
            	// Get value from the cell
            	return cell.getValue();
            }
        }
        return 0;
    }

    // method to print the board
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
