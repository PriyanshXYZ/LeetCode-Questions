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
    
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,50001,0);
        
    }
    public int dfs(TreeNode root,int min, int max){
        if(root==null)return max-min;
        int currMax = Math.max(max, root.val);
        int currMin = Math.min(min, root.val);
        int left = dfs(root.left, currMin, currMax);
        
        int right = dfs(root.right, currMin, currMax);
        
        return Math.max(left, right);
    }
}