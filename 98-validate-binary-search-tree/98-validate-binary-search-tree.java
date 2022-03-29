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
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        
        //faith
        boolean ansLeft=isValidBST(root.left);
        if(prev!=null && prev>=root.val){
            return false;
        }else{
            prev=root.val;
        }
        boolean ansRight=isValidBST(root.right);
        return ansLeft && ansRight;
    }
}