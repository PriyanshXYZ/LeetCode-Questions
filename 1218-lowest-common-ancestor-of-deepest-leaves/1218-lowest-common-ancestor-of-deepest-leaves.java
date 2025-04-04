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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root.left==null && root.right==null)return root;

        int ht = findHt(root);
        return dfs(root,ht);
    }

    private int findHt(TreeNode root) {
        if(root==null)return 0;
        return Math.max(findHt(root.left),findHt(root.right))+1;
    }

    private TreeNode dfs(TreeNode root, int ht){
        if(root == null)return null;

        TreeNode left = dfs(root.left,ht-1);
        TreeNode right = dfs(root.right,ht-1);
        
        if(ht==1)return root;
        if(left!=null && right!=null)return root;
        else if(left!=null)return left;
        else if(right!=null)return right;
        return null;
    }
}

class Solution1 {
    TreeNode lca;
    int maxDepth;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root.left==null && root.right==null)return root;
        dfs(root,0);
        return lca;
    }

    private int dfs(TreeNode root, int ht){
        maxDepth = Math.max(maxDepth, ht);
        if(root == null)return ht;

        int left = dfs(root.left,ht+1);
        int right = dfs(root.right,ht+1);
        
        if(left==maxDepth && right==maxDepth){
            lca = root;
        }
        return Math.max(left,right);
    }
}