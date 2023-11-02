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
    int cnt;
    public int averageOfSubtree(TreeNode root) {
        cnt = 0;
        dfs(root);
        return cnt;
    }
    
    public int[] dfs(TreeNode root){
        if(root == null)return new int[]{0,0};
        
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        int subtreeNodeCnt = left[1] + right[1] + 1;
        int subtreeSum = left[0] + right[0] + root.val;
        
        if(root.val == subtreeSum/ subtreeNodeCnt)cnt++;
        
        return new int[]{subtreeSum, subtreeNodeCnt};
    }
}