class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        Arrays.sort(nums);
        
        backtrack(nums,0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> results) {
        results.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums,i+1,current,results);
            current.remove(current.size()-1);
        }
    }
}
