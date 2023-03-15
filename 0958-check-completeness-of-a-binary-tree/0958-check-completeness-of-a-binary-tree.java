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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean prevIncomplete = false;
        while(q.size()>0){
            int size = q.size();
            
            while(size-- > 0){
                TreeNode rem = q.remove();
                
                if(rem==null){
                    prevIncomplete = true;
                }else{
                    if(prevIncomplete)return false;
                    q.add(rem.left);
                    q.add(rem.right);
                }
            }
        }
        return true;
    }
}