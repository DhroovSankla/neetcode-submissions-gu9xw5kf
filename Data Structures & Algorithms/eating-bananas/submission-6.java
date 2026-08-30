class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int res = r;

        while (l <= r) {
            int midSpeed = l + (r - l) / 2;

            if (canFinish(piles, h, midSpeed)) {
                res = midSpeed;
                r = midSpeed - 1;
            } else {
                l = midSpeed + 1;
            }
        }
        return res;
    }

    private boolean canFinish(int [] piles , int h , int k) {
        long totalHours = 0;
        for(int pile : piles) {
            totalHours += (pile + k -1) / k;
        }
        return totalHours <= h;
    }
}
