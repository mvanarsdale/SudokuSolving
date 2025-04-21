package sudokuSolver;

/** 
* 
* Main class for sudoku solver
* April 21, 2025
*/
public class Main {
    public static void main(String[] args) {
        // create instance of SudokuGraphBuilder
        SudokuGraphBuilder builder = new SudokuGraphBuilder();
        
        // build the graph
        builder.buildGraph();

        // set values (graph from ChatGPT (change to read from file later))
        builder.setCellNum(0, 0, 5);
        builder.setCellNum(0, 1, 3);
        builder.setCellNum(0, 4, 7);
        builder.setCellNum(1, 0, 6);
        builder.setCellNum(1, 3, 1);
        builder.setCellNum(1, 4, 9);
        builder.setCellNum(1, 5, 5);
        builder.setCellNum(2, 1, 9);
        builder.setCellNum(2, 2, 8);
        builder.setCellNum(2, 7, 6);
        builder.setCellNum(3, 0, 8);
        builder.setCellNum(3, 4, 6);
        builder.setCellNum(3, 8, 3);
        builder.setCellNum(4, 0, 4);
        builder.setCellNum(4, 3, 8);
        builder.setCellNum(4, 5, 3);
        builder.setCellNum(4, 8, 1);
        builder.setCellNum(5, 0, 7);
        builder.setCellNum(5, 4, 2);
        builder.setCellNum(5, 8, 6);
        builder.setCellNum(6, 1, 6);
        builder.setCellNum(6, 6, 2);
        builder.setCellNum(6, 7, 8);
        builder.setCellNum(7, 3, 4);
        builder.setCellNum(7, 4, 1);
        builder.setCellNum(7, 5, 9);
        builder.setCellNum(7, 8, 5);
        builder.setCellNum(8, 4, 8);
        builder.setCellNum(8, 7, 7);
        builder.setCellNum(8, 8, 9);

        // print function
        builder.printBoard();
    }
}
