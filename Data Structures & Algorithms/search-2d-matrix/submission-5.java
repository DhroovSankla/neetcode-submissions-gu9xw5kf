class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix == null || matrix.length == 0) return false;
         
         int rows = matrix.length;
         int cols = matrix[0].length;

         int l = 0;
         int r = (rows * cols) - 1;

         while(l <= r) {
            int mid = l + (r - l)/2;
            int midValue = matrix[mid / cols][mid % cols];

            if(midValue == target) {
                return true;
            } 
            else if(midValue < target) {
              l = mid + 1; 
            }
            else {
                r = mid - 1;
            }
         }
         return false;
    }
}
