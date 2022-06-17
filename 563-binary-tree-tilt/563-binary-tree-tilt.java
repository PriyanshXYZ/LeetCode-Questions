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
    int tiltSum=0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return tiltSum;
    }
    
    public int dfs(TreeNode root){
        if(root==null)return 0;
        
        int leftSum=dfs(root.left);
        int rightSum=dfs(root.right);
        
        int currTiltSum=Math.abs(leftSum-rightSum);
        
        tiltSum+=currTiltSum;
        return leftSum+rightSum+root.val;
        
    }
}