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
class Solution1 {
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
        }else if(lch!=null && rch!=null){//left and right both subtree has deepest leaf present
            return root;
        }else if(lch!=null){//left subtree has deepest leaf present
            return lch;
        }else if(rch!=null){//right subtree has deepest leaf present
            return rch;
        }
        else{//if subtree has no depth==deepest nodes
            return null;
        }
        
    }
}
class Solution {
    TreeNode lca;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
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
        
        if(lchDepth==maxDepth && rchDepth==maxDepth){//we got the deepest leafs
            lca=root;
        }
        return Math.max(lchDepth,rchDepth);
    }
}