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
    
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] idx={0};
        return dfs(idx,preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode dfs(int[] idx,int[] pre,int min,int max){
        //base case
        if(idx[0]==pre.length || pre[idx[0]]>=max || pre[idx[0]]<=min)return null;
        
        TreeNode node=new TreeNode(pre[idx[0]]);
        idx[0]=idx[0]+1;
        node.left=dfs(idx,pre,min,node.val);
        node.right=dfs(idx,pre,node.val,max);
        return node;
    }
    
    public TreeNode bstFromPostorder(int[] postorder) {
        int[] idx={postorder.length-1};
        return dfs(idx,postorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public TreeNode dfs1(int[] idx,int[] post,int min,int max){
        //base case
        if(idx[0]==-1 || post[idx[0]]>=max || post[idx[0]]<=min)return null;
        
        TreeNode node=new TreeNode(post[idx[0]]);
        idx[0]=idx[0]-1;
        node.right=dfs1(idx,post,node.val,max);
        node.left=dfs1(idx,post,min,node.val);
        
        return node;
    }
}