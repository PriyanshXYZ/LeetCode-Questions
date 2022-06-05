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
    int maxDia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDia;
    }
    public int height(TreeNode root){
        if(root==null)return -1;
        
        int left=height(root.left);
        int right=height(root.right);
        
        int dia=left+right+2;
        maxDia=Math.max(dia,maxDia);
        
        return Math.max(left,right)+1;
    }
}