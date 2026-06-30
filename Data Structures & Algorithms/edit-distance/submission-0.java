class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        Integer[][] memo = new Integer[m][n];
        return solve(m - 1, n - 1, word1, word2, memo);
    }

    private int solve(int i, int j, String w1, String w2, Integer[][] memo) {

        if (i < 0)
            return j + 1;

        if (j < 0)
            return i + 1;

        if (memo[i][j] != null)
            return memo[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = solve(i - 1, j - 1, w1, w2, memo);
        }

        else {
            int insertOp = solve(i, j - 1, w1, w2, memo);
            int deleteOp = solve(i - 1, j, w1, w2, memo);
            int replaceOp = solve(i - 1, j - 1, w1, w2, memo);

            memo[i][j] = 1 + Math.min(insertOp, Math.min(deleteOp, replaceOp));
        }

        return memo[i][j];
    }
}