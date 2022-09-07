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
    String str;
    public String tree2str(TreeNode root) {
        str="";
        recursion(root);
        return str;
    }
    public void recursion(TreeNode root){
        if(root==null)return;
        
        str+=root.val+"";
        if(root.left!=null){
            str+='(';
            recursion(root.left);
            str+=')';
        }else{
            if(root.right==null){
                return;
            }
            str+="()";
        }
        
        if(root.right!=null){
            str+='(';
            recursion(root.right);
            str+=')';
        }else{
            recursion(root.right);
        }
    }
}