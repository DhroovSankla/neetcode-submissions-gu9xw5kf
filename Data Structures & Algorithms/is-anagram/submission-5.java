class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;

        StringBuilder sb = new StringBuilder(t);

        for(int i = 0; i < s.length(); i++) {
            char str = s.charAt(i);
             boolean isMatch = false;


             for(int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) == str) {
                    sb.deleteCharAt(j);
                    isMatch = true;
                    break;
                }
             }
             if(!isMatch) {
                return false;
             }
        }
        return true;
    }
}
