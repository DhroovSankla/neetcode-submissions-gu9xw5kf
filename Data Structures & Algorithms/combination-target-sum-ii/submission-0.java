class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(candidates);
        bt(candidates, target, 0, new ArrayList<>(), rs);
        return rs;
    }
    private void bt(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> rs) {
        if (target == 0) {
            rs.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            
            if (candidates[i] > target) {
                break;
            }
           
           if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            curr.add(candidates[i]);
            bt(candidates, target - candidates[i], i+1, curr, rs);
            curr.remove(curr.size() - 1);
        }
    }
}
