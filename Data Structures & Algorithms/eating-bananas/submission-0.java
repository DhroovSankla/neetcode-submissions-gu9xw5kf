class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        
        // Find the maximum pile to set our upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Helper function to check if 'mid' speed is possible
            if (canFinish(piles, h, mid)) {
                result = mid; // This speed works, try to find a smaller one
                right = mid - 1;
            } else {
                left = mid + 1; // Too slow, increase speed
            }
        }
        
        return result;
    }
    
    private boolean canFinish(int[] piles, int h, int speed) {
        long totalHours = 0; // Use long to prevent overflow
        for (int pile : piles) {
            // Calculate ceiling of (pile / speed)
            // Equivalent to (pile + speed - 1) / speed
            totalHours += (pile + speed - 1) / speed;
        }
        return totalHours <= h;
    }
}