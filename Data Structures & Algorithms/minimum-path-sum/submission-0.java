class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] memo = new Integer[m][n];

        return solve(m-1,n-1,grid,memo);
    }

    private int solve(int i, int j, int[][] grid, Integer[][] memo) {
        if(i == 0 && j == 0) return grid[0][0];

        if(i < 0 || j < 0) return (int) 1e9;

        if(memo[i][j] != null) return memo[i][j];

        int fT = solve(i-1,j,grid,memo);
        int fL = solve(i,j-1,grid,memo);

        memo[i][j] = grid[i][j] + Math.min(fT,fL);

        return memo[i][j];
    }
}