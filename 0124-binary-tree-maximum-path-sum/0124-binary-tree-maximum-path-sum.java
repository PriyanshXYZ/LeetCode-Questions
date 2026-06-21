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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //sum can include 
        // self 
        // left subtree matching condition
        // right subtree matching condition
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftSum = Math.max(dfs(node.left), 0);
        int rightSum = Math.max(dfs(node.right), 0);
        
        int maxPathSumIncRoot = Math.max(leftSum, rightSum) + node.val;
        int currMaxSum = leftSum + rightSum + node.val;
        maxSum = Math.max(currMaxSum, maxSum);

        return maxPathSumIncRoot;
    }
}