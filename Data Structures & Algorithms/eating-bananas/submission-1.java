class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }
        
        for (int k = 1; k <= maxPile; k++) {
            if (canFinish(piles, h, k)) {
                return k; 
            }
        }
        return maxPile;
    }
    
    private boolean canFinish(int[] piles, int h, int k) {
        int totalHours = 0;
        for (int pile : piles) {
            totalHours += (pile + k - 1) / k;
        }
        return totalHours <= h;
    }
}