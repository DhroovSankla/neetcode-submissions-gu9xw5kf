class Solution {
    public boolean canJump(int[] nums) {
        return canJumpPosition(0,nums);
    }
    private boolean canJumpPosition(int position, int[] nums) {
        if(position >= nums.length - 1) {
            return true;
        }

        int maxJump = nums[position];

        for(int step = 1; step <= maxJump; step++) {
            int nextPosition = position + step;

            if(canJumpPosition(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }
}
