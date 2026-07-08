class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list,root);
        return list;
    }

    private void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;

        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }
}