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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null || q==null){
            if(p==null && q==null){
                return true;
            }
            return false;
        }
        if(p.val!=q.val)return false;
        
        boolean ans1=isSameTree(p.left,q.left);
        boolean ans2=isSameTree(p.right,q.right);
        return ans1 && ans2;
    }
}