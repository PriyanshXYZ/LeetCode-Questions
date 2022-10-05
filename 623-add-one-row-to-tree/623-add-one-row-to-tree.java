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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth ==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        dfs(root,val,1,depth);
        return root;
    }
    public void dfs(TreeNode root,int val,int currDepth,int depth){
        if(root==null)return;
        
        if(currDepth+1==depth){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=left;
            root.right.right=right;
        }
        dfs(root.left,val,currDepth+1,depth);
        dfs(root.right,val,currDepth+1,depth);
    }
}