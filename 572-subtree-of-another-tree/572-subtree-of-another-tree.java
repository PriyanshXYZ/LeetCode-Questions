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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)return false;
        
        boolean ans=false;
        if(subRoot.val==root.val){
            ans=isIdentical(root,subRoot);
            if(ans)return true;
        }
        
        boolean inLeft=isSubtree(root.left,subRoot);
        boolean inRight=isSubtree(root.right,subRoot);
        
        return inLeft || inRight;
    }
    public boolean isIdentical(TreeNode root,TreeNode node){
        
        if(root==null || node==null){
            if(root==null && node==null)
                return true;
            
            return false;
        }
        if(root.val!=node.val)return false;
        
        boolean leftSide=isIdentical(root.left,node.left);
        boolean rightSide=isIdentical(root.right,node.right);

        return leftSide && rightSide;
    }
}