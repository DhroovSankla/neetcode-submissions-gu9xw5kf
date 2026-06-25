class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n,cost,memo);
    }

    private int solve(int i, int[] cost, int[] memo) {
        if(i == 0 || i == 1) return 0;

        if(memo[i] != -1) return memo[i];

        int tOS = solve(i - 1, cost, memo) + cost[i - 1];
        int tTS = solve(i - 2, cost, memo) + cost[i - 2];
        
        memo[i] = Math.min(tOS,tTS);
        return memo[i]; 
    }
}
