class Solution {
    public int search(int[] nums, int target) {
        
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] == target) {
                return nums[target];
            }
        }
        return -1;
    }
}
