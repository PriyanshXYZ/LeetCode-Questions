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
    List<Integer> path;
    public List<Integer> inorderTraversal(TreeNode root) {
        path = new ArrayList<>();
        dfs(root);
        return path;
    }

    private void dfs(TreeNode root) {
        if(root == null) return;

        dfs(root.left);
        path.add(root.val);
        dfs(root.right);
    }
}