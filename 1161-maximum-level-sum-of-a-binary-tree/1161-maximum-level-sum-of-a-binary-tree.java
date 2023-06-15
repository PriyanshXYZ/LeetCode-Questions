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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        int lvl = 1;
        q.add(root);
        
        int maxCnt = Integer.MIN_VALUE;
        int ans = 1;
        while(q.size() > 0){
            int size = q.size();
            int sum = 0;
            while(size-- > 0){
                TreeNode rem = q.remove();
                sum += rem.val;
                if(rem.left!=null)q.add(rem.left);
                if(rem.right!=null)q.add(rem.right);
            }
            if(maxCnt < sum){
                maxCnt = sum;
                ans = lvl;
            }
            lvl++;
        }
        return ans;
    }
}