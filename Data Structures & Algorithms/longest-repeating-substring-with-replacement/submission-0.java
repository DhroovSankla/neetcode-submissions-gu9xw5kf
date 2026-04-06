class Solution {
public int characterReplacement(String s, int k) {
    int[] freq = new int[26]; // Frequency array for 'A'-'Z'
    int left = 0;
    int maxFreq = 0;
    int maxLength = 0;

    for (int right = 0; right < s.length(); right++) {
        // 1. Expand: Add the new character
        char curr = s.charAt(right);
        freq[curr - 'A']++;
        
        // 2. Update maxFreq: Is the new character now the most frequent?
        maxFreq = Math.max(maxFreq, freq[curr - 'A']);

        // 3. Check Validity: Do we need more than 'k' replacements?
        // (Window Size - maxFreq) > k
        while ((right - left + 1) - maxFreq > k) {
            // Shrink from the left
            freq[s.charAt(left) - 'A']--;
            left++;
            // Note: We don't need to decrease maxFreq here. 
            // The result only changes if we find a window with an even higher maxFreq.
        }

        // 4. Update Result
        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength; 
  }
}