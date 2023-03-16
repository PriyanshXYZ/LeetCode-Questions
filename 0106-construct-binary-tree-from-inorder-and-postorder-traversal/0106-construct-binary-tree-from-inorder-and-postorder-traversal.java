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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(0, inorder.length - 1, 0, postorder.length - 1, map, postorder);
    }
    public TreeNode dfs(int in_lo, int in_hi, int p_lo, int p_hi, HashMap<Integer,Integer> in, int[] post){
        if(in_lo>in_hi || p_lo > p_hi) return null;
        
        TreeNode root = new TreeNode(post[p_hi]);
        int idx = in.get(post[p_hi]);
        int leftSize = idx - in_lo;
        
        root.left = dfs(in_lo, idx - 1, p_lo, p_lo + leftSize - 1, in, post);
        root.right = dfs(idx + 1, in_hi, p_lo + leftSize, p_hi - 1, in, post);
        return root;
    }
}