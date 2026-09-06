class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        bt(nums, target, 0, new ArrayList<>(), rs);
        return rs;
    }
    private void bt(int[] nums, int target, int start, List<Integer> curr, List<List<Integer>> rs) {
        if (target == 0) {
            rs.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            curr.add(nums[i]);
            bt(nums, target - nums[i], i, curr, rs);
            curr.remove(curr.size() - 1);
        }
    }
}
