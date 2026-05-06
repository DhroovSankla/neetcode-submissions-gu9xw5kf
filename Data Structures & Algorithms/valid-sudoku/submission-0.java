class Solution {
    public boolean isValidSudoku(char[][] board) {
         char [i],[j];
        if (board.length == 9) {
            if (board[i].length == 9) {

                if (board[i][j] >= 1 && board[i][j] <= 9) {
                    return true;
                }
            }
        }
        return false;
    }
}
