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
    
    public void flatten(TreeNode root) {
        TreeNode[] prev=new TreeNode[1];
        dfs(root,prev);
    }
    
    public void dfs(TreeNode root,TreeNode[] prev){
        if(root==null)return;
        
        TreeNode origLeft=root.left;
        TreeNode origRight=root.right;
        if(prev[0]!=null){
            prev[0].right=root;
            prev[0].left=null;
        }
        prev[0]=root;
        dfs(origLeft,prev);
        dfs(origRight,prev);
    }
}