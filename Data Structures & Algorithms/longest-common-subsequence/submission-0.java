class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        Integer[][] memo = new Integer[m][n];

        return solve(m - 1, n - 1, text1, text2, memo);
    }

    private int solve(int i, int j, String t1, String t2, Integer[][] memo) {
        if (i < 0 || j < 0)
            return 0;

        if (memo[i][j] != null)
            return memo[i][j];

        if (t1.charAt(i) == t2.charAt(j)) {
            memo[i][j] = 1 + solve(i - 1, j - 1, t1, t2, memo);
        }

        else {
            int sT1 = solve(i - 1, j, t1, t2, memo);
            int sT2 = solve(i, j - 1, t1, t2, memo);
            memo[i][j] = Math.max(sT1, sT2);
        }

        return memo[i][j];
    }
}