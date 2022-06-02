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
        preorder(root);
    }
    public void preorder(TreeNode root){
        if(root==null)return;
        
        TreeNode origLeft=root.left;//to preserve the nodes which are going to change
        TreeNode origRight=root.right;//to preserve the nodes which are going to change
        if(prev!=null){
            prev.left=null;
            prev.right=root;    
        }
        prev=root;
        preorder(origLeft);
        preorder(origRight);
    }
}