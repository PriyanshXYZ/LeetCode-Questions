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
    public List<String> binaryTreePaths(TreeNode root) {
        //add at leave node to the list
        List<String> result = new ArrayList();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String psf, List<String> result) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            result.add(psf + ""+ root.val);
            return;
        }

        dfs(root.left,psf + "" + root.val + "->", result);
        dfs(root.right,psf + "" + root.val + "->", result);
    }
}