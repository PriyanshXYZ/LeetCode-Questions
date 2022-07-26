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
        //base case
        if(p.val==root.val || q.val==root.val) return root;
        
        //faith 
        TreeNode leftChild=lowestCommonAncestor(root.left,p,q);
        TreeNode rightChild=lowestCommonAncestor(root.right,p,q);
        
        //post order work
        //if left and right child both return something then it mean that the curr root is lowest common ancestor...
        if(leftChild!=null && rightChild!=null) return root;
        //if any one of child/descendant returns something just return the same
        if(leftChild!=null) return leftChild;
        return rightChild;
    }
}