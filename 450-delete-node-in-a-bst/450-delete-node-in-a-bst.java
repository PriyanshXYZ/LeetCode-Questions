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
    public int max(TreeNode root){
        if(root==null)return Integer.MIN_VALUE;
        
        return Math.max(max(root.right),root.val);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root==null)return null;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }else if(key>root.val){
            root.right=deleteNode(root.right,key);
            return root;
        }else{
            //when we found the key
            //there are 3 possible cases
            //1 : key is leaf
            if(root.left==null && root.right==null){
                return null;
            }
            
            //2 : key has a single child
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            //3 : key has both child
            //this can be done by finding justSmaller or justLarger of the subtree and replace the values of it
            int justSmaller=max(root.left);
            root.val=justSmaller;
            root.left=deleteNode(root.left,justSmaller);
            return root;
        }
    }
}