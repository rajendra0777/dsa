/*
Time Complexity: (O(9^m))
Space Complexity: \(O(m)\) (Auxiliary Space: \(O(1)\) or \(O(N^2)\))

        Steps
        -find  empty cell
        -Try numbers from 1 to 9.
        -Check valid placement
        -Place num and explore for next num
        -Backtrack if stuck
*/


class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // check empty cell
                if (grid[row][col] == '.') {

                    // try all posibilities
                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (validPlace(grid, row, col, ch)) {
                            //place
                            grid[row][col] = ch;
                            // explore
                            if (solve(grid))
                                return true;

                            grid[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validPlace(char[][] grid, int row, int col, char ch) {
        for (int index = 0; index <= 8; index++) {
            if (grid[row][index] == ch || grid[index][col] == ch)
                return false;

            int subRow = 3 * (row / 3) + (index / 3);
            int subCol = 3 * (col / 3) + (index % 3);

            if (grid[subRow][subCol] == ch)
                return false;
        }

        return true;
    }
}