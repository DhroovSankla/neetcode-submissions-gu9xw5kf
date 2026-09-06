class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        boolean[] vd = new boolean[nums.length];
        bt(nums,vd,new ArrayList<>(),rs);
        return rs;
    }

    private void bt(int[] nums, boolean[] vd, List<Integer> curr, List<List<Integer>> rs) {
        if(curr.size() == nums.length) {
            rs.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i <  nums.length; i++) {
            if(vd[i]) continue;

            curr.add(nums[i]);
            vd[i] = true;

            bt(nums,vd,curr,rs);

            curr.remove(curr.size()-1);
            vd[i] = false;
        }
    }
}
