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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=construct(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
        return root;
    }
    public TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int[] pre,int[] in){
        if(pre_lo>pre_hi || in_lo>in_hi)return null;
        TreeNode root=new TreeNode(pre[pre_lo]);
        //to get position of  curr node in the inorder array
        int idx=in_lo;
        while(pre[pre_lo]!=in[idx]){
            idx++;
        }
        //leftSubtreeSizeIndex
        int lhs=idx-in_lo;
        root.left=construct(pre_lo+1,pre_lo+lhs,in_lo,idx-1,pre,in);
        root.right=construct(pre_lo+lhs+1,pre_hi,idx+1,in_hi,pre,in);
        return root;
    }
    
}