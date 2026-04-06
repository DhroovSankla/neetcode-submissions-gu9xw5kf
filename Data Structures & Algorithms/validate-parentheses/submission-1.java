class Solution {
    public boolean isValid(String s) {
        Deque<Character> sc = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                sc.push(c);
            }
            else {
                if(sc.isEmpty()) {
                    return false;
                }
                char top = sc.pop();

                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
            }
        }
        return sc.isEmpty();
    }
}
