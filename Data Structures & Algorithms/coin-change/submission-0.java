class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        Integer[][] memo = new Integer[n][amount + 1];

        int rs = solve(n - 1, amount, coins, memo);

        return rs >= 1e9 ? -1 : rs;
    }

    private int solve(int i, int amount, int[] coins, Integer[][] memo) {
        if (amount == 0)
            return 0;

        if (i < 0 || amount < 0)
            return (int) 1e9;

        if (memo[i][amount] != null)
            return memo[i][amount];

        int take = (int) 1e9;
        if (coins[i] <= amount) {
            take = 1 + solve(i, amount - coins[i], coins, memo);
        }

        int skip = solve(i - 1, amount, coins, memo);

        memo[i][amount] = Math.min(take, skip);
        return memo[i][amount];
    }
}
