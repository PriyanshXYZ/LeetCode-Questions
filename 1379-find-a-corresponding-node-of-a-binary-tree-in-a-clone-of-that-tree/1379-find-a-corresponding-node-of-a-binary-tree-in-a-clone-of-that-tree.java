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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null)return null;
        
        
        TreeNode lch=getTargetCopy(original.left,cloned.left,target);
        if(target==original){
            return cloned;
        }
        TreeNode rch=getTargetCopy(original.right,cloned.right,target);
        
        if(lch!=null){
            return lch;
        }
        return rch;
    }
}