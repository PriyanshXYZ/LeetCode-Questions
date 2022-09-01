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
    public int goodNodes(TreeNode root) {
        count=0;
        dfs(root,root.val);
        return count;
    }
    int count;
    public void dfs(TreeNode root,int max){
        if(root==null)return;
        
        if(max<=root.val){
            count++;
            max=root.val;
        }
        
        dfs(root.left,max);
        dfs(root.right,max);
        
    }
}