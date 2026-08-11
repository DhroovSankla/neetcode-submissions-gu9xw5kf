class Solution {
    public int trap(int[] height) {
        
        int l = 0;
        int r = height.length-1;

        int leftM = 0;
        int rightM = 0;
        int totalW = 0;

        while(l < r) {
            if(height[l] < height[r]) {
                if(height[l] >= leftM) {
                    leftM = height[l];
                } else {
                    totalW += leftM - height[l];
                }
                l++;
            } else {
                if(height[r] >= rightM) {
                    rightM = height[r];
                } else {
                    totalW += rightM - height[r];
                }
                r--;
            }
        } 
        return totalW;
    }
}
