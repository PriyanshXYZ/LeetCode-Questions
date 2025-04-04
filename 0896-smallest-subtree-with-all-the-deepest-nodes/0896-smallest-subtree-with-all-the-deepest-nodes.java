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
    TreeNode lca;
    int maxDepth;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        lca=null;
        maxDepth=0;
        depth(root,0);
        return lca;
    }
    public int depth(TreeNode root,int depth){
        maxDepth = Math.max(depth,maxDepth);
        if(root==null){
            return depth;
        }
        
        int lchDepth=depth(root.left,depth+1);
        int rchDepth=depth(root.right,depth+1);
        
        if(lchDepth==maxDepth && rchDepth==maxDepth){//we got our lca
            lca=root;
        }
        return Math.max(lchDepth,rchDepth);
    }
}