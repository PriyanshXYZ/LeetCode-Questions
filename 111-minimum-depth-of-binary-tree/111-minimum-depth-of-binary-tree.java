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
    public int minDepth(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new ArrayDeque();
        int level=1;
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            while(size-->0){
                TreeNode rnode=q.remove();
                if(rnode.left==null && rnode.right==null)return level;//leaf node
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            level++;
        }
        return level;
    }
    public int dfs(TreeNode root){
        if(root==null)return 0;
        if(root.left==null && root.right==null)return 1;
        
        if(root.left==null)return dfs(root.right)+1;
        
        if(root.right==null)return dfs(root.left)+1;
        
        int left=dfs(root.left);
        int right=dfs(root.right);
        
        return Math.min(left,right)+1;
    }
}