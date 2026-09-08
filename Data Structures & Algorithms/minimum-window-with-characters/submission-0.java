class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n < m || m == 0)
            return "";

        int[] targetCount = new int[128];
        for (char c : t.toCharArray()) {
            targetCount[c]++;
        }

        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        for (int i = 0; i < n; i++) {
            int[] windowCount = new int[128];

            for (int j = i; j < n; j++) {
                windowCount[s.charAt(j)]++;

                if (j - i + 1 >= minLen)
                    break;

                if (isValid(windowCount, targetCount)) {
                    minLen = j - i + 1;
                    startIndex = i;
                    break;
                }
            }
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }

    private boolean isValid(int[] window, int[] target) {
        for (int i = 0; i < 128; i++) {
            if (target[i] > 0 && window[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}