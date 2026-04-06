class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // Work from the left side
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // Update new max
                } else {
                    totalWater += leftMax - height[left]; // Trap water
                }
                left++;
            } else {
                // Work from the right side
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Update new max
                } else {
                    totalWater += rightMax - height[right]; // Trap water
                }
                right--;
            }
        }
        return totalWater;
    }
}
