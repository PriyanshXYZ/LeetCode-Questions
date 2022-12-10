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
// class Solution {
//     long res = 0, total = 0;
//     public int maxProduct(TreeNode root) {
//         total = s(root); s(root);
//         return (int)(res % (int)(1e9 + 7));
//     }

//     private long s(TreeNode root) {
//         if (root == null) return 0;
//         long sub = root.val + s(root.left) + s(root.right);
//         res = Math.max(res, sub * (total - sub));
//         return sub;
//     }
// }
class Solution {
    long ans,total;
    int mod=(int)(1e9+7);
    public int maxProduct(TreeNode root) {
        total=sum(root);
        ans=0;
        dfs(root);
        return (int)(ans%mod);
    }
    private long sum(TreeNode root){
        if(root==null)return 0;
        return sum(root.left) + sum(root.right) + root.val;
    }
    private long dfs(TreeNode root){
        if(root == null)return 0;
        
        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);
        // long sub=leftSum + rightSum + root.val;
        ans=Math.max(ans,(total-leftSum) * (leftSum));
        ans=Math.max(ans,(total - rightSum) * (rightSum));
        return leftSum + rightSum + root.val;
    }
}