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
        HashMap<Integer,Integer> map=new HashMap();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        TreeNode root=construct(0,n-1,0,n-1,preorder,map);
        
        return root;
    }
    
    public TreeNode construct(int pre_lo,int pre_hi,int in_lo,int in_hi,int[] pre,HashMap<Integer,Integer> in){
        //base case
        if(pre_lo>pre_hi || in_lo>in_hi)return null;
        TreeNode root=new TreeNode(pre[pre_lo]);
        
        int idx=in_lo;
        if(pre_lo+1<=pre_hi){
            idx=in.get(pre[pre_lo]);
        }
        int lhsize=idx-in_lo;
        
        root.left=construct(pre_lo+1,pre_lo+lhsize,in_lo,idx-1,pre,in);
        root.right=construct(pre_lo+lhsize+1,pre_hi,idx+1,in_hi,pre,in);
        return root;
    }
}