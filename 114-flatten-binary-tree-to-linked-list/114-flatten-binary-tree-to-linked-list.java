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
    //using O(1) space
    
    public void flatten(TreeNode root) {
        // TreeNode prev=null;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev=curr.left;
                while(prev.right!=null){
                    prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}
class Solution1 {
    //O(n) time and space
    TreeNode prev;
    public void flatten(TreeNode root) {
        if(root==null)return;
        
        TreeNode origLeft=root.left;
        TreeNode origRight=root.right;
        
        if(prev!=null){
            prev.right=root;
            prev.left=null;
        }
        
        prev=root;
        flatten(origLeft);
        flatten(origRight);
    }
}