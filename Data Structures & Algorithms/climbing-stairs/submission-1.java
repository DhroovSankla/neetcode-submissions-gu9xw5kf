class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return isDP(n,memo);
    }
    private int isDP(int n , int[] memo) {
        if(n == 0 || n == 1) return 1;

        if(memo[n] != 0) {
            return memo[n];
        }

        memo[n] = isDP(n-1,memo) + isDP(n-2,memo);
        return memo[n];
    }
}
