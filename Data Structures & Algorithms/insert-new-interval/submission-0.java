class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int[][] combined = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            combined[i] = intervals[i];
        }
        combined[n] = newInterval;

        Arrays.sort(combined, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] interval : combined) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] =
                    Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
