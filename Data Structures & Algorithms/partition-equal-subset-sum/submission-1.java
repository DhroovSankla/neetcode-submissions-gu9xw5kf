class Solution {
  public boolean canPartition(int[] nums) {
    int totalSum = 0;
    for (int num : nums) totalSum += num;
    
    if (totalSum % 2 != 0) return false;
    
    int target = totalSum / 2;
    int n = nums.length;
    
    boolean[][] dp = new boolean[n][target + 1];
    
    for (int i = 0; i < n; i++) {
        dp[i][0] = true;
    }
    
    if (nums[0] <= target) {
        dp[0][nums[0]] = true;
    }
    
    for (int i = 1; i < n; i++) {
        for (int j = 1; j <= target; j++) {
            
            boolean skip = dp[i - 1][j];
            
            boolean take = false;
            
            if (nums[i] <= j) {
                take = dp[i - 1][j - nums[i]];
            }
            
            dp[i][j] = take || skip;
        }
    } 
    return dp[n - 1][target]; 
    }
}