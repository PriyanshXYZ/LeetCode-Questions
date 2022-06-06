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
    int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        if(maxDia>0)
            maxDia--;
        return maxDia;
    }
    public int height(TreeNode root){
        if(root==null)return 0;
        
        int left=height(root.left);
        int right=height(root.right);
        
        int dia=left+right+1;
        maxDia=Math.max(dia,maxDia);
        
        return Math.max(left,right)+1;
    }
}
