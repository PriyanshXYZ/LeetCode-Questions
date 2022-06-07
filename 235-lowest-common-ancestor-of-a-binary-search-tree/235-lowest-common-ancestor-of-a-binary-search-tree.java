/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        //using log(N) time complexity
        if(root.val>p.val && root.val>q.val){
            //this means that  lowest common node may exist in left of a BST 
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val< p.val && root.val< q.val){
            //this means that lowest common node may exist in right of a BST 
            return lowestCommonAncestor(root.right,p,q);
        }else{
            /*this will handle the following cases
            CASE 1
            when root.val>p.val && root.val<q.val => which means current node is the required               lowest common ancestor(due to properties of BST)
            
            CASE 2
            when root.val==p.val || root.val==q.val =>which means that one of the node is lowest             common ancestor of other node
            
            */
            
            return root; 
        }
    }
}