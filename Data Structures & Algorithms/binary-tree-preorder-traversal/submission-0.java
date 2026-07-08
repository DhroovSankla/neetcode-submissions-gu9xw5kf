class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list,root);
        return list;
    }

    private void preOrder(List<Integer> list, TreeNode root) {
        if(root == null) return ;

        list.add(root.val);
        preOrder(list,root.left);
        preOrder(list,root.right);
    }
}