class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 0) return 0;
        if(n == 1) return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < n; i++) {

            int rC = nums[i] + dp[i-2];
            int sC = dp[i-1];

            dp[i] = Math.max(rC,sC);
        }
        return dp[n-1];
    }
}
