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
    public int countNodes(TreeNode root) {
        return size(root);
    }
    
    //TC O(n)
    public int size(TreeNode root){
        if(root==null)return 0;
        
        int lch=size(root.left);
        int rch=size(root.right);
        return lch+rch+1;
    }
    //TC O(log(n)^2)
    public int optimized(TreeNode root){
        if(root==null)return 0;
        
        int lh=0;
        TreeNode node=root.left;
        while(node!=null){
            node=node.left;
            lh++;
        }
        
        int rh=0;
        node=root.right;
        while(node!=null){
            node=node.right;
            rh++;
        }
        
        
        if(lh==rh){
            int ht=lh+1;
            return (1 << ht) -1;
        }else{
            return optimized(root.left)+optimized(root.right)+1;
        }
            
    }
}