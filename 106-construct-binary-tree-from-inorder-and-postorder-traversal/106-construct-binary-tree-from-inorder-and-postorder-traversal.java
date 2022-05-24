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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=construct(0,postorder.length-1,0,inorder.length-1,postorder,map);
        return root;
    }
    
    private TreeNode construct(int post_lo,int post_hi,int in_lo,int in_hi,int[] post,HashMap<Integer,Integer> map){
        //base case
        if(post_lo> post_hi || in_lo>in_hi)return null;
        
        TreeNode root=new TreeNode(post[post_hi]);
        //finding idx of corresponding root in inorder
        int idx=map.get(post[post_hi]);
        //no of right side children in the array are 
        int rhs=in_hi -idx;
        
        root.left=construct(post_lo,post_hi-1-rhs,in_lo,idx-1,post,map);
        root.right=construct(post_hi-rhs,post_hi-1,idx+1,in_hi,post,map);
        return root;
    }
}