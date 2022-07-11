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
        if(root==null)return new ArrayList();
        Queue<TreeNode> q=new ArrayDeque();
        List<Integer> ans=new ArrayList();
        q.add(root);
        
        while(q.size()>0){
            int size=q.size();
            while(size-- >0){
                TreeNode rNode=q.remove();
                if(size==0)ans.add(rNode.val);
                if(rNode.left!=null)q.add(rNode.left);
                if(rNode.right!=null)q.add(rNode.right);
            }
        }
        return ans;
    }
}