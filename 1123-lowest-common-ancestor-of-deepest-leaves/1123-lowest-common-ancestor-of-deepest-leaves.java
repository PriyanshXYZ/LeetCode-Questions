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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth=depth(root);
        TreeNode lca=lcaAtDepth(root,maxDepth);
        return lca;
    }
    public int depth(TreeNode root){
        if(root==null)return 0;
        
        int left=depth(root.left);
        int right=depth(root.right);
        
        return Math.max(left,right)+1;
    }
    public TreeNode lcaAtDepth(TreeNode root,int depth){
        if(root==null)return null;
        
        TreeNode lch=lcaAtDepth(root.left,depth-1);
        TreeNode rch=lcaAtDepth(root.right,depth-1);
        
        if(depth==1){
            return root;
        }else if(lch!=null && rch!=null){
            return root;
        }else if(lch!=null){
            return lch;
        }else if(rch!=null){
            return rch;
        }
        else{
            return null;
        }
        
    }
}