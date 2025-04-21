# Sudoku

Uploading to GitHub:
Add working components to main 
Add in progress components to individual branch

Paper:
https://www.researchgate.net/publication/358642884_Comparison_Analysis_of_Breadth_First_Search_and_Depth_Limited_Search_Algorithms_in_Sudoku_GameLinks to an external site.

Requirements:
1. Work with a partner.
2. Implement their solution as described: You will need to use a graph data structure, BFS, and a variation of DFS (called depth-limited search).
3. Add a proper citation for the paper in your header.
4. Keep track of solutions found or not found. As the paper notes, BFS especially may find more than one solution.

To Know:
You may use Java libraries for all of these. You may also start with code found online for a Sudoku solver that uses a graph. Cite your source.

Improvements:
Now the fun part: Improve on what they did!!! You have a choice:
Adjust their approach so that it works regardless of the grid size but still runs on a standard computer. (You may need to implement threading or some way to manage memory.)
Adjust their approach to work on a 3D sudoku.

Last year’s 301 did a Rubik’s cube paper that used a combination of BFS and DLS… I wonder if that combo could work with Sudoku… (last year’s paper is at https://www.researchgate.net/publication/326749335_Solving_Rubik%27s_Cube_Using_Graph_Theory_ICCI-2017Links to an external site.)

Write a BRIEF summary (1 page max) of your improvement: Does it work on any puzzle or only sometimes? Is it efficient time- or space-wise? Is it better for finding a solution fast or for finding multiple solutions? And most important: WHY???
Note: Depending on the improvement you chose, you might not need to answer all of these questions and/or you may have other things you should say about it.
Don’t just throw this together. You can turn this program into another portfolio-worthy project to help you get a job (which is the real reason you need to add the paper’s citation).


-Rubric-
10 pts: Reads in a file of easy, medium, and hard Sudoku puzzles (that you create) to test with.
20 pts: Uses a graph to solve the puzzle
20 pts: Applies BFS to each puzzle
5 pts: Keeps track of solutions, especially multiple solutions.
20 pts: Applies DLS to each puzzle
5 pts: Keeps track of solutions, especially multiple solutions.
40 pts: Implements one of the suggested improvements.
10 pts: Improvement is very well commented, especially what adjustments you made and why.
30 pts: Results summary clearly explains what you did, how it worked, and its strengths/limitations (see above questions).
5 pts: Paper and borrowed code cited
5 pts: Comments and style
