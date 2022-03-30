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
    public int max(TreeNode node){
        if(node==null) return Integer.MIN_VALUE;
        return Math.max(max(node.right),node.val);
    }
    public TreeNode deleteNode(TreeNode node, int data) {
    if(node==null)return null;
    if(node.val>data){
      node.left=deleteNode(node.left,data);
      return node;
    }else if(node.val<data){
      node.right=deleteNode(node.right,data);
      return node;
    }else{
      //case1
      if(node.left==null && node.right==null){
        return null;
      }
      //case2
      if(node.left==null){
        return node.right;
      }
      if(node.right==null){
        return node.left;
      }
      //case3
      int justSmaller=max(node.left);
      node.val=justSmaller;
      node.left=deleteNode(node.left,justSmaller);
      return node;
    }
    
  }
}