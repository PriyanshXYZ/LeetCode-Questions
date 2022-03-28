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
    public List<String> binaryTreePaths(TreeNode root) {
        String str="";
        return n2r(root,str);
    }
    public List<String> n2r(TreeNode root,String str){
         if(root==null)return new ArrayList();
        //check for leaf nodes and then add them in arraylist
        
        if(root.left==null && root.right==null){
            List<String> base=new ArrayList();
            base.add(str+root.val);
            return base;
        }
        str+=root.val+"->";
        //faith
        List<String> leftChild=n2r(root.left,str);
        List<String> rightChild=n2r(root.right,str);
        
        List<String> ans=new ArrayList();
        ans.addAll(leftChild);
        ans.addAll(rightChild);
        return ans;
    }
}