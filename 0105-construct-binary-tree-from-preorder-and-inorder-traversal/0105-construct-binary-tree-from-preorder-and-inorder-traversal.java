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
    //properties which can help 
    Map<Integer,Integer> inorderIdxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //expectation is to child will get build if i build my current node properly!
        inorderIdxMap = new HashMap<>();
        int n = preorder.length;
        for(int i = 0 ; i < inorder.length; i++) { 
            inorderIdxMap.put(inorder[i], i);
        }
        return dfs( 0, n - 1, 0, n - 1, preorder);
    }

    private TreeNode dfs(int p_lo, int p_hi, int i_lo, int i_hi, int[] p) {
        //base case
        if(p_lo>p_hi || i_lo > i_hi)return null;

        TreeNode node = new TreeNode(p[p_lo]);
        int iIdx = p_lo;
        iIdx = inorderIdxMap.get(p[p_lo]);
        
        int leftTreeSize = iIdx - i_lo;

        node.left = dfs(p_lo + 1, p_lo + leftTreeSize, i_lo , iIdx - 1, p);
        node.right = dfs(p_lo + leftTreeSize + 1, p_hi, iIdx + 1, i_hi, p);

        return node;
    }
}