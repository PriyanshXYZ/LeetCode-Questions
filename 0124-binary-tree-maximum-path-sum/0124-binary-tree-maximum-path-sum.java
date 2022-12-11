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
        dfs2(root);
        return maxSum;
    }
    public int dfs2(TreeNode root){
        //base case
        if(root==null)return 0;
        int left=dfs2(root.left);
        int right=dfs2(root.right);
        
        int left_dash=Math.max(0,left);//handling negative value
        int right_dash=Math.max(0,right);//handling negative value
        
        int currMaxIncRoot=Math.max(left_dash,right_dash)+root.val;
            
        int currN2N=left_dash+right_dash+root.val;
        
        maxSum=Math.max(maxSum,currN2N);
        
        
        return currMaxIncRoot;
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
        
        maxSum=Math.max(maxSum,Math.max(currMaxSumIncRoot,Math.max(root.val,allPathSum)));//leftSum and rightSum cannot be added because there possibility of whole tree having negative values;
        return Math.max(root.val,Math.max(lchMaxSumIncRoot,rchMaxSumIncRoot));
        
    }
}