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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList();
        List<Integer> ans=new ArrayList();
        Queue<TreeNode> q=new ArrayDeque();
        q.add(root);
        while(q.size()>0){
            int size=q.size();
            TreeNode rnode=null;
            while(size-->0){
                rnode=q.remove();
                if(rnode.left!=null)q.add(rnode.left);
                if(rnode.right!=null)q.add(rnode.right);
            }
            ans.add(rnode.val);
        }
        return ans;
    }
}