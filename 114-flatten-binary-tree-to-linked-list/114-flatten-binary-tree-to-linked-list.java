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
    TreeNode prev;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    public void dfs(TreeNode root){
        if(root==null)return;
        
        TreeNode origLeft=root.left;
        TreeNode origRight=root.right;
        if(prev!=null){
            prev.right=root;
            prev.left=null;
        }
        prev=root;
        dfs(origLeft);
        dfs(origRight);
    }
}