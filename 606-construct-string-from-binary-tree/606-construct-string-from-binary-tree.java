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
    StringBuilder str;
    public String tree2str(TreeNode root) {
        str=new StringBuilder();
        recursion(root);
        return str.toString();
    }
    public void recursion(TreeNode root){
        if(root==null)return;
        
        str.append(root.val);
        if(root.left!=null){
            str.append('(');
            recursion(root.left);
            str.append(')');
        }else{
            if(root.right==null){
                return;
            }
            str.append("()");
        }
        
        if(root.right!=null){
            str.append('(');
            recursion(root.right);
            str.append(')');
        }else{
            recursion(root.right);
        }
    }
}