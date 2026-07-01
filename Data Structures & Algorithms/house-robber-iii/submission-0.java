/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<>();
        return solve(root, memo);
    }

    private int solve(TreeNode root, HashMap<TreeNode, Integer> memo) {
        if (root == null)
            return 0;

        if (memo.containsKey(root))
            return memo.get(root);

        int currR = root.val;

        if (root.left != null) {
            currR += solve(root.left.left, memo) + solve(root.left.right, memo);
        }
        if (root.right != null) {
            currR += solve(root.right.right, memo) + solve(root.right.left, memo);
        }

        int skipR = solve(root.left, memo) + solve(root.right, memo);

        int res = Math.max(currR, skipR);
        memo.put(root, res);
        return res;
    }
}