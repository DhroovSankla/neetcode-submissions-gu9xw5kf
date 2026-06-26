class Solution {
    public boolean canPartition(int[] nums) {
        int ts = 0;
        for (int num : nums) ts += num;

        if (ts % 2 != 0)
            return false;

        int target = ts / 2;
        int n = nums.length;

        Boolean[][] memo = new Boolean[n][target + 1];

        return solve(n - 1, target, nums, memo);
    }

    private boolean solve(int i, int target, int[] nums, Boolean[][] memo) {
        if (target == 0)
            return true;

        if (i < 0 || target < 0)
            return false;

        if (memo[i][target] != null)
            return memo[i][target];

        boolean take = false;
        if (nums[i] <= target) {
            take = solve(i - 1, target - nums[i], nums, memo);
        }

        boolean skip = solve(i - 1, target, nums, memo);

        memo[i][target] = take || skip;
        return memo[i][target];
    }
}
