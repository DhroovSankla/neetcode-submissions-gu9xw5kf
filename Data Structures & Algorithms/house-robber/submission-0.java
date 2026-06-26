class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        return isSolve(n-1,nums,memo);
    }

    private int isSolve(int i , int[] nums, int[] memo) {
        if (i < 0) return 0;

        if(i == 0) return nums[0];

        if(memo[i] != -1) return memo[i];

        int rC = nums[i] + isSolve(i-2,nums,memo);
        int sC = isSolve(i-1,nums,memo);

        memo[i] = Math.max(rC,sC);
        return memo[i];
    }
}
