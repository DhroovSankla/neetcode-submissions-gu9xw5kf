class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean hasX = false;
        boolean hasY = false;
        boolean hasZ = false;

        for(int[] t : triplets) {
            if(t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            if(t[0] == target[0]) hasX = true;
            if(t[1] == target[1]) hasY = true;
            if(t[2] == target[2]) hasZ = true;        

            if(hasX && hasY && hasZ) {
                return true;
            }      
        }
        return hasX && hasY && hasZ;
    }
}
