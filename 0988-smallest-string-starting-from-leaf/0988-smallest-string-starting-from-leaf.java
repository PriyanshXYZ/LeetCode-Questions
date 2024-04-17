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
    String res = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }
    public void dfs(TreeNode root, String str) {
        if(root == null)return;
        
        str = (char)(root.val + 'a') + str;
        if(root.left==null && root.right == null){
            if(res==null || res.compareTo(str) > 0) {
                res = str;
            }
            return;
        }
        dfs(root.left, str);
        dfs(root.right, str);
    }
}