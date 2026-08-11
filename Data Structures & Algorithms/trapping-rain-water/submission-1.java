class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;

        for(int i = 0; i < n; i++) {
            int maxLeft = 0;
            int maxRight = 0;

            for(int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for(int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            int waterLevel = Math.min(maxLeft,maxRight);

            totalWater += waterLevel - height[i];
        }
        return totalWater;
    }
}
