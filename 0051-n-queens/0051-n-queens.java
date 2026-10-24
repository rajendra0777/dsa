/*
TC: O(N!); Prenin
SC: O(N.M) + O(N)
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        // create Board
        char[][] board = createBoard(n);
        solve(board, 0, ans);
        return ans;

    }

    private void solve(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(convertToList(board));
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';

                // recurisive call
                solve(board, row + 1, ans);
                // keep clear 
                board[row][col] = '.';
            }
        }
        return;
    }

    private boolean isValid(char[][] board, int row, int col) {
        int tempRow = row;
        int tempCol = col;

        // top
        while (tempRow >= 0) {
            if (board[tempRow][tempCol] == 'Q')
                return false;

            tempRow--;
        }

        // top left diagonal
        tempRow = row;
        tempCol = col;
        while (tempRow >= 0 && tempCol >= 0) {
            if (board[tempRow][tempCol] == 'Q')
                return false;

            tempRow--;
            tempCol--;
        }

        // top right diagonal
        tempRow = row;
        tempCol = col;
        while (tempRow >= 0 && tempCol < board.length) {
            if (board[tempRow][tempCol] == 'Q')
                return false;

            tempRow--;
            tempCol++;
        }
        return true;
    }

    private char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        // fill with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return board;

    }

    private List<String> convertToList(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char[] ch : board) {
            list.add(new String(ch));
        }
        return list;
    }
}