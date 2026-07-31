class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currentLvl = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                currentLvl.add(node.val);

                if(node.left  != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
                
            }
            res.add(currentLvl);
        }
        return res;
    }
}
