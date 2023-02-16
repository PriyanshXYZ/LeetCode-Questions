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
      public int maxDepthBfs(TreeNode root) {
        //iterative
        if(root==null) return 0;
        int level=0;
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                TreeNode rnode=q.remove();
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            level++;
        }
        return level;
    }
    
    public int maxDepth(TreeNode root) {
        return helper(0,root);
    }
    public int helper(int depth,TreeNode root){
        if(root==null)return 0;
        
        int left=helper(depth,root.left);
        int right=helper(depth,root.right);
        return Math.max(left,right) + 1;
    }
}