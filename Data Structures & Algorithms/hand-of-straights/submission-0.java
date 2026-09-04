class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);
        boolean[] used = new boolean[hand.length];

        for (int i = 0; i < hand.length; i++) {
            if (used[i]) {
                continue;
            }

            int currentVal = hand[i];
            used[i] = true;
            int count = 1;

            for (int j = i + 1; j < hand.length && count < groupSize; j++) {
                if (!used[j] && hand[j] == currentVal + 1) {
                    used[j] = true;
                    currentVal = hand[j];
                    count++;
                }
            }

            if (count < groupSize) {
                return false;
            }
        }
        return true;
    }
}