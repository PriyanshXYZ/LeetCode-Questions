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
    public TreeNode pruneTree(TreeNode root) {
        if(dfs(root)){
            return root;
        }
        return null;
    }
    public boolean dfs(TreeNode root){
        if(root==null)return false;
        if(root.left==null && root.right==null && root.val==1)return true;
        if(root.left==null && root.right==null && root.val==0)return false;
        boolean l=dfs(root.left);
        boolean r=dfs(root.right);
        if(l==false && r==false){
            root.left=null;
            root.right=null;
            return root.val==1 ;
        }
        if(l==false){
            root.left=null;
            return true;
        }
        if(r==false){
            root.right=null;
            return true;
        }
        return root.val==1 || l || r;
    }
}