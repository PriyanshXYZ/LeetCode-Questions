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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        
        TreeNode right = invertTree(root.left);//we need to make right child left one and vice versa
        TreeNode left = invertTree(root.right);
        
        TreeNode curr = new TreeNode(root.val);
        curr.left = left;
        curr.right= right;
        return curr;
    }
    
}