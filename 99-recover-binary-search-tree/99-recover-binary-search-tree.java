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
    TreeNode first=null;
    TreeNode second=null;
    TreeNode prev=null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        swap(first,second);
        
    }
    public void swap(TreeNode n1,TreeNode n2){
        int temp=n1.val;
        n1.val=n2.val;
        n2.val=temp;
    }
   
    public void inorder(TreeNode root){
        if(root==null) return;
        
        inorder(root.left);
        //in case we get curr node smaller than prev node we update first
        if(prev!=null){
            if(first==null && root.val<=prev.val){
                first=prev;
            }
        }
        // when first is already found and we get smaller node than prev
        if(first!=null && root.val<=prev.val){
            second=root;
        }
        prev=root;

        inorder(root.right);
        
        return;
    }
}