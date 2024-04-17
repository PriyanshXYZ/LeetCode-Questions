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
    TreeSet<String> set;
    public String smallestFromLeaf(TreeNode root) {
        set = new TreeSet<>();
        dfs(root, "");
        return set.first();
    }
    public void dfs(TreeNode root, String res) {
        if(root == null){
            return;
        }
        res = (char)(root.val + 'a') + res;
        if(root.left == null && root.right == null) {
            set.add(res);
            return;
        }
        
        dfs(root.left, res);
        dfs(root.right, res);
        
    }
}