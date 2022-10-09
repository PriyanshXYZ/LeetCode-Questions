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
    List<Integer> l;
    public boolean findTarget(TreeNode root, int k) {
        l=new ArrayList();
        
        dfs(root);
        int i=0,j=l.size()-1;
        while(i<j){
            if(l.get(i)+l.get(j)==k){
                return true;
            }else if(l.get(i)+l.get(j)>k){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    public void dfs(TreeNode root){
        if(root==null)return;
        
        dfs(root.left);
        l.add(root.val);
        dfs(root.right);
        
    }
}