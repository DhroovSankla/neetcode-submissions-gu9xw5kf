class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filtered = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                filtered.append(Character.toLowerCase(ch));
            }
        }

        StringBuilder reversed = new StringBuilder();
        for(int i = filtered.length()-1; i >= 0; i--) {
            reversed.append(filtered.charAt(i));
        }

        return filtered.toString().equals(reversed.toString());
    }
}
