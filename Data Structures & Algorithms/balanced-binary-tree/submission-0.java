
class Solution {
    public boolean isBalanced(TreeNode root) {
       return dfsheight(root) != -1;
    }
    private int dfsheight(TreeNode root) {
         if(root == null) return 0;

         int leftHeight = dfsheight(root.left);
         if(leftHeight == -1) return -1;

         int rightHeight = dfsheight(root.right);
         if(rightHeight == -1) return -1;

         if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
         }

         return 1 + Math.max(leftHeight,rightHeight);
        }
}
