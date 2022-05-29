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
    Integer prev;
    public boolean isValidBST(TreeNode root) {
        if(root==null)return true;
        
        boolean left=isValidBST(root.left);
        if(prev==null || prev<root.val){
            prev=root.val;
        }else{
            return false;
        }
        
        boolean right=isValidBST(root.right);
        return left && right;
    }
}
class Solution1 {
    class Pair{
        boolean isBst=true;
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
    }
    public boolean isValidBST(TreeNode root) {
        Pair node=dfs(root);
        return node.isBst;
    }
    public Pair dfs(TreeNode root){
        if(root==null)return new Pair();
        
        Pair lp=dfs(root.left);
        Pair rp=dfs(root.right);
        
        Pair self=new Pair();
        self.isBst=lp.isBst && rp.isBst && lp.max<root.val && rp.min>root.val;
        self.min=Math.min(root.val,lp.min);
        self.max=Math.max(root.val,rp.max);
        return self;
    }
    
}