# SudokuSolving

✦ Day 1: Graph Modeling & Input Parsing 💻
Goal: Build the graph model of Sudoku using the graph lib
To-do:
* Install/import the graph library you’ll use (like org.jgrapht) (*°∀°)=3
* Create a Vertex class or just use (row,col) as keys (´∨`)
* Add all 81 vertices to your graph ✧(｡•̀ᴗ-)✧
* For each vertex, connect it to:
    * same row
    * same column
    * same 3×3 box
* Write a method to read Sudoku puzzles from a 9×9 array or string
* Print out some node connections to test 🕵️‍♀️
Estimated Time: 3–4 hrs of chill coding (*´▽｀)ﾉﾉ

✦ Day 2: Constraint Checking & Valid Moves 🧩🚫
Goal: Make the logic to check which numbers are valid for each cell
To-do:
* Write a method like Set<Integer> getValidValues(Vertex v)
* For a given vertex, check all its neighbors’ values
* Remove those values from the list {1...9} （｡>‿‿<｡ ）
* Return the remaining as valid options! ✨
Estimated Time: 4 hrs (some debugging might happen here, totally normal) Σ(゜゜)

✦ Day 3: BFS Solver Logic 🌀💡
Goal: Create the solving engine using BFS traversal
To-do:
* Define a BoardState class or structure to hold the board and current progress
* Use a queue for BFS (like LinkedList<BoardState>) ✧(｡•̀ᴗ-)✧
* In each step:
    * Find the next empty cell
    * Try each valid number
    * Enqueue a new board state for each valid move
* Stop when a complete board is reached 🏁
Estimated Time: 5–6 hrs (this is the brain-intensive part, snack up 🍫✨)

✦ Day 4: Optimization & Cleanup 💅💡
Goal: Speed things up & reduce memory usage
To-do:
* Implement MRV heuristic: pick the cell with the fewest options first (smart girl move) 🧠
* Avoid re-checking same states: hash the board to detect duplicates
* Use pruning to skip impossible paths early (ง ͠° ͟ʖ ͡°)ง
* Add logs or counters to measure performance ((o(>ω<)o))
Estimated Time: 3–4 hrs (make it ✨sleek✨)

✦ Day 5: UI / Testing / Flex ✨📸
Goal: Show off your brilliance, baby 💖💖💖
To-do:
* Create a pretty console output or simple UI to show solved Sudoku
* Test on:
    * Easy puzzle
    * Medium
    * Evil/Hard af puzzles 👀
* Add comments + documentation 📝
* Maybe add puzzle input from a file or GUI if you’re feeling ✨extra✨
Estimated Time: 4 hrs 🎉 You’re DONE and it’s time to flex it to your friends & stackoverflow ✨Ψ(≧ω≦)Ψ
