class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;

        int[] count = new int[128];

        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            count[ch]++;

            while (count[ch] > 1) {
                char leftChar = s.charAt(left);
                count[leftChar]--;
                left++;
            }
            maxLength = Math.max(maxLength, right -left + 1);
        }
        return maxLength;
    }
}
