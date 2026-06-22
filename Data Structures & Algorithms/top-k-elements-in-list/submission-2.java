class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<int[]> freq = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(visited.contains(nums[i])) continue;

            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            freq.add(new int[] {nums[i],count});
            visited.add(nums[i]);
        }
        freq.sort((a,b) -> b[1] - a[1]);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = freq.get(i)[0];
        }

        return result;
    }
}
