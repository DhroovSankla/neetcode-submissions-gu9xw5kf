class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> currentLevelValues = new ArrayList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelValues.add(currentNode.val);

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

           res.add(currentLevelValues); 
        }
        return res;
    }
}