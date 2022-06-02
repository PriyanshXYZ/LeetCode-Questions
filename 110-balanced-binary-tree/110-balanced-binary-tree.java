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
    boolean balanced=true;
    public boolean isBalanced(TreeNode root) {
        recursion(root);
        return balanced;
    }
    
    public int recursion(TreeNode root){
        if(root==null)return 0;
        
        int lht=recursion(root.left);
        int rht=recursion(root.right);
        
        balanced &= Math.abs(lht-rht)<=1?true:false;
        return Math.max(lht,rht)+1;
    }
}