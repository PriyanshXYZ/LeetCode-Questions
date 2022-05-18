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
    int xleftSubTreeSum=0;
    int xrightSubTreeSum=0;
    public int size(TreeNode root,int x){
        if(root==null)return 0;
        
        int lch=size(root.left,x);
        int rch=size(root.right,x);
        //if the root is x we get left and right no of nodes sum
        if(root.val==x){
            xleftSubTreeSum=lch;
            xrightSubTreeSum=rch;
        }
        return lch+rch+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        size(root,x);
        
        //now we have ancestor subtree sum of left and right
        int otherSide=n-(xleftSubTreeSum + xrightSubTreeSum+1);
        
        //finding max of all subtree possible
        int max=Math.max(otherSide,Math.max(xrightSubTreeSum,xleftSubTreeSum));
        
        int rest=n-max;
        
        if(rest>max){
            return false ;
        }
        return true;
    }
}