class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder filter = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                filter.append(Character.toLowerCase(ch));
            }
        }

        StringBuilder reverse = new StringBuilder();
        for(int i = filter.length()-1; i >= 0; i--) {
            reverse.append(filter.charAt(i));
        }

        return filter.toString().equals(reverse.toString());
    }
}
