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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)return 0;
        
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        int levelsum=0;
        while(q.size()>0){
            levelsum=0;
            int size=q.size();
            while(size-- >0){
                TreeNode rnode=q.remove(); 
                levelsum+=rnode.val;
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            
        }
        return levelsum;
    }
}