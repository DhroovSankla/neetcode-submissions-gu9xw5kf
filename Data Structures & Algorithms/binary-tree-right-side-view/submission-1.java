class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth , List<Integer> res) {
        if(root == null) return;

        if(depth == res.size()) {
            res.add(root.val);
        }

        dfs(root.right,depth+1,res);
        dfs(root.left,depth+1,res);
    }
}
