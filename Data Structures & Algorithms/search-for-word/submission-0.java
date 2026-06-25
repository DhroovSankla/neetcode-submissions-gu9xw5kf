class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (bt(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bt(char[][] board, int r, int c, String word, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length
            || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = bt(board, r + 1, c, word, index + 1) || bt(board, r - 1, c, word, index + 1)
            || bt(board, r, c + 1, word, index + 1) || bt(board, r, c - 1, word, index + 1);

        board[r][c] = temp;

        return found;
    }
}
