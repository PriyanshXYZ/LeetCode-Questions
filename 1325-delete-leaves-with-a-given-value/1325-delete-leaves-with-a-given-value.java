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
    public TreeNode removeLeafNodes(TreeNode node, int target) {
        if(node==null)return null;
        
        
        TreeNode lch=removeLeafNodes(node.left,target);
        TreeNode rch=removeLeafNodes(node.right,target);
        
        if(node.val==target && lch==null && rch==null){
            return null;
        }
        node.left=lch;
        node.right=rch;
        return  node;
        
    }
}