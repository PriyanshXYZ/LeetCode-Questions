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
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        for(int i=0;i<in.size();i++){
            TreeNode curr=in.get(i);
            TreeNode next=i+1<in.size()?in.get(i+1):null;
            curr.right=next;
            curr.left=null;
        }
        return in.get(0);
    }
    List<TreeNode> in=new ArrayList(); 
    public void inorder(TreeNode root){
        if(root==null)return;
        
        inorder(root.left);
        in.add(root);
        inorder(root.right);
    }
}