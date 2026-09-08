class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] targetCount = new int[128];
        int requiredDistinct = 0;
        for (char c : t.toCharArray()) {
            if (targetCount[c] == 0) {
                requiredDistinct++;
            }
            targetCount[c]++;
        }

        int[] windowCount = new int[128];
        int formed = 0;

        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            windowCount[rChar]++;

            if (targetCount[rChar] > 0 && windowCount[rChar] == targetCount[rChar]) {
                formed++;
            }

            while (left <= right && formed == requiredDistinct) {
                int currentLen = right - left + 1;
                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = left;
                }

                char lChar = s.charAt(left);
                windowCount[lChar]--;

                if (targetCount[lChar] > 0 && windowCount[lChar] < targetCount[lChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}