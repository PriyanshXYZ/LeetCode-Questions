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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<postorder.length;i++){
            map.put(postorder[i],i);
        }
        TreeNode root=construct(0,preorder.length-1,0,postorder.length-1,preorder,map);
        return root;
    }
    public TreeNode construct(int pre_lo,int pre_hi,int post_lo,int post_hi,int[] pre,HashMap<Integer,Integer> map){
        //base case
        if(pre_lo>pre_hi || post_lo>post_hi)return null;
        TreeNode root=new TreeNode(pre[pre_lo]);
        /*
            1. finding left side index
                a. start pre order left side is end of post order left side 
                b. we can either find length of right or left side both of which will work 
        */
        if(pre_lo+1<=pre_hi){
            int searchIdx=map.get(pre[pre_lo+1]);
            int lhs=searchIdx-post_lo+1;
            
            root.left=construct(pre_lo+1,pre_lo+lhs,post_lo,searchIdx,pre,map);
            root.right=construct(pre_lo+lhs+1,pre_hi,searchIdx+1,post_hi-1,pre,map);
        }
        return root;
    }
}