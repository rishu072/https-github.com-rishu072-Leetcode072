class Solution {
    public boolean isSafe(char[][] board, int row, int col) {

        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void nQueens(char[][] board, int row,
                        List<List<String>> ans) {

        if (row == board.length) {

            List<String> temp = new ArrayList<>();

            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int j = 0; j < board.length; j++) {

            if (isSafe(board, row, j)) {

                board[row][j] = 'Q';

                nQueens(board, row + 1, ans);

                board[row][j] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();

        nQueens(board, 0, ans);

        return ans;
    }
}
