class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vd = new boolean[nums.length];
        bt(nums, vd, new ArrayList<>(), rs);
        return rs;
    }

    private void bt(int[] nums, boolean[] vd, List<Integer> curr, List<List<Integer>> rs) {

        if (curr.size() == nums.length) {
            rs.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vd[i])
                continue;

            if (i > 0 && nums[i] == nums[i - 1] && !vd[i - 1])
                continue;

            curr.add(nums[i]);
            vd[i] = true;

            bt(nums, vd, curr, rs);

            curr.remove(curr.size() - 1);
            vd[i] = false;
        }
    }
}