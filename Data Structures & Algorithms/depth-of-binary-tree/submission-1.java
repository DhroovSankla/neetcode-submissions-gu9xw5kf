class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftdepth = maxDepth(root.left);
        int rightdepth = maxDepth(root.right);

        int depth = 1 + Math.max(leftdepth,rightdepth);
          
          return depth;
    }
}
