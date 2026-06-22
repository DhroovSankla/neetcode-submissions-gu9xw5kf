class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            List<String> currentGrp = new ArrayList<>();
            currentGrp.add(strs[i]);
            visited[i] = true;

            for(int j = i+1; j < n; j++){
                if(!visited[j] && isAnagram(strs[i],strs[j])) {
                    currentGrp.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(currentGrp);
        }
        return result;
    }
     private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
