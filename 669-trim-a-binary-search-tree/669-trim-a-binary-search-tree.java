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
    public int max(TreeNode root){
        if(root==null)return Integer.MIN_VALUE;
        return Math.max(max(root.right),root.val);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return null;
        
        if(root.val<low){
            return trimBST(root.right,low,high);
        }
        if(root.val>high){
            return trimBST(root.left,low,high);
        }
        root.left=trimBST(root.left,low,high);
        root.right=trimBST(root.right,low,high);
        return root;
    }
}