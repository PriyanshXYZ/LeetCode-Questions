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
    public TreeNode invertTree(TreeNode root) {
       return invertTreeBfs(root);
    }
    public TreeNode invertTreeDfs(TreeNode root) {
        //using dfs
        if(root==null) return null;
        //faith
        if(root.left!=null) invertTree(root.left);
        if(root.right!=null) invertTree(root.right);
        //post order work
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        return root;
    }
    public TreeNode invertTreeBfs(TreeNode root){
        //using bfs
        if(root==null) return null;
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(q.size()>0){
                TreeNode rnode=q.remove();
                TreeNode node=rnode.left;
                rnode.left=rnode.right;
                rnode.right=node;
                if(rnode.left!=null) q.add(rnode.left);
                if(rnode.right!=null) q.add(rnode.right);
        }
        return root;
    }
}