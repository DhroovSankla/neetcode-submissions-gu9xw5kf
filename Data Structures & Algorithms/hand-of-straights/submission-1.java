class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        while (!countMap.isEmpty()) {
            int firstCard = countMap.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int nextCard = firstCard + i;

                if (!countMap.containsKey(nextCard)) {
                    return false;
                }

                int count = countMap.get(nextCard);
                if (count == 1) {
                    countMap.remove(nextCard);
                } else {
                    countMap.put(nextCard, count - 1);
                }
            }
        }

        return true;
    }
}
