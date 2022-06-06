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
    int count=0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root,-1001);
        if(count>0){
            count=count-1;
        }
        return count;
    }
    public int dfs(TreeNode root,int parentVal){
        if(root==null)return 0;
        int currCount=1;
        int left=dfs(root.left,root.val);
        int right=dfs(root.right,root.val);
        
        //change in count if it is larger
        count=Math.max(count,left+right+1);
        
        if(root.val==parentVal){
            return Math.max(left,right)+1;//return max height
        }else{
            return 0;
        }
    }
}