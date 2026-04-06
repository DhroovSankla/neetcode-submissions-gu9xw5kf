class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Map to store the last index of each character
        HashMap<Character, Integer> map = new HashMap<>();

        // 'right' expands the window, 'left' shrinks it
        for (int left = 0, right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If we've seen this character before, move the 'left' pointer
            // to the right of the previous occurrence
            if (map.containsKey(currentChar)) {
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update/Put the current character's index
            map.put(currentChar, right);

            // Calculate the current window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
