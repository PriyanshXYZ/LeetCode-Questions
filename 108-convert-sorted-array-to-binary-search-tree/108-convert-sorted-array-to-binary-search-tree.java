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
    public TreeNode sortedArrayToBST(int[] nums) {
        int lo=0,hi=nums.length-1;
        return toBST(nums,lo,hi);
    }
    public TreeNode toBST(int[] a,int lo,int hi){
        if(lo>hi) return null;
        
        int mid=lo+(hi-lo)/2;
        TreeNode node=new TreeNode(a[mid]);
        TreeNode left=toBST(a,lo,mid-1);
        TreeNode right=toBST(a,mid+1,hi);
        
        node.left=left;
        node.right=right;
        return node;
    }
}