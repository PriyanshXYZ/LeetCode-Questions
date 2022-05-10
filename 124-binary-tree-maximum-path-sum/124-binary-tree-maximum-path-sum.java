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
    static int maxPathSum;
    public int maxPathSum(TreeNode root) {
        maxPathSum=Integer.MIN_VALUE;
        dfs(root);
        return maxPathSum;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;//here we cannot get any gain
        
        int leftPathSum=dfs(root.left);
        int rightPathSum=dfs(root.right);
        
        int leftIncludingRoot=leftPathSum+root.val;
        int rightIncludingRoot=rightPathSum+root.val;
        int bestLeftRight=Math.max(leftIncludingRoot,rightIncludingRoot);
        int allPath=leftPathSum+rightPathSum +root.val;
        maxPathSum=Math.max(maxPathSum,Math.max(root.val,Math.max(bestLeftRight,allPath)));//leftSum and rightSum cannot be added because there possibility of whole tree having negative values;
        return Math.max(root.val,Math.max(leftIncludingRoot,rightIncludingRoot));
    }
}