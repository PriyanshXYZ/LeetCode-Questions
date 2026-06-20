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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return ans;
    }

    private void dfs(TreeNode node, int path) {
        if(node == null)return;
        path*=10;
        path+=node.val;
        if(node.left == null && node.right == null) {
            System.out.println(path);
            ans += path;
            return;
        }

        dfs(node.left, path);
        dfs(node.right, path);
    }
}