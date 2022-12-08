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
    List<Integer> l1;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        l1=new ArrayList();
        dfs1(root1);
        // System.out.println(l1);
        idx=0;
        if(dfs2(root2) && idx==l1.size())return true;
        return false;
    }
    public void dfs1(TreeNode root){
        if(root==null)return;
        if(root.left==null && root.right==null){
            l1.add(root.val);
        }
        dfs1(root.left);
        dfs1(root.right);
    }
    int idx;
    public boolean dfs2(TreeNode root){
        if(root==null)return true;
        if(idx>=l1.size())return false;
        if(root.left==null && root.right==null){
            if(l1.get(idx)!=root.val){
                idx++;
                return false;
            }else{
                idx++;
                return true;
            }
        }
        return dfs2(root.left) && dfs2(root.right);
    }
}