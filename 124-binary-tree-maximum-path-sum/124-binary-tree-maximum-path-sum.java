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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0; //no gain in ans 
        
        int lchMaxSum=dfs(root.left);
        int rchMaxSum=dfs(root.right);
        
        int lchMaxSumIncRoot=lchMaxSum+root.val;
        int rchMaxSumIncRoot=rchMaxSum+root.val;
        
        int currMaxSum=Math.max(lchMaxSum,rchMaxSum);//this cannot be added to maxSum as path will be discontinous
        int currMaxSumIncRoot=currMaxSum+root.val;
        int allPathSum=lchMaxSum+rchMaxSum+root.val;
        
        maxSum=Math.max(maxSum,Math.max(currMaxSumIncRoot,Math.max(root.val,allPathSum)));
        //possibility of root as negative as well
        return Math.max(root.val,Math.max(lchMaxSumIncRoot,rchMaxSumIncRoot));
        
    }
}