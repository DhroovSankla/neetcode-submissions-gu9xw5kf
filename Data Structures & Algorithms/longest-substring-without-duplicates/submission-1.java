class Solution {
public int lengthOfLongestSubstring(String s) {
    int n = s.length();
    int maxLength = 0;
    int left = 0;
    
    // Frequency array to store characters in the current window
    int[] count = new int[128]; 

    for (int right = 0; right < n; right++) {
        char ch = s.charAt(right);
        count[ch]++;

        // If count[ch] > 1, we have a duplicate. Shrink the window from the left.
        while (count[ch] > 1) {
            char leftChar = s.charAt(left);
            count[leftChar]--;
            left++;
        }

        // Update the max length (right - left + 1 is the window size)
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
}
}